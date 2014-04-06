import std.stdio;
import std.string;
import std.file;
import std.conv;
import std.utf;
import std.regex;

enum LogType { WARN, ERROR, INFO };
string[string] variables;

int main(char[][] args) {
	if(args.length > 1) {
		char[][] arguments = args[1..args.length];

		foreach(char[] inputFile; arguments) {
			string input = to!string(inputFile);
			string contents;
			if(exists(input) && isFile(input)) {
				try {
					contents = readFile(input);

					int index = 0;
					foreach(string line; splitLines(contents)) {
						index++;
						processLine(line, index, input);
					}
				} catch (Exception ex) {
					log("Textual wasn't able to open '" ~ input ~ "'.", LogType.ERROR);
				}
			} else {
				log("The path '" ~ input ~ "' doesn't exist, or isn't a file.", LogType.ERROR);
			}
		}

	} else {
		log("No input file specified.", LogType.ERROR);
		return 0;
	}

	return 0;
}

void log(string message, LogType type) {
	if(type == LogType.WARN) {
		writeln("[WARNING] ", message);
	} else if(type == LogType.ERROR) {
		writeln("[ERROR] ", message);
	} else if(type == LogType.INFO) {
		writeln("[INFO] ", message);
	}
}

void processLine(string line, int lineNumber, string fileName){
	//Handle line input
	line = strip(line);
	if(line.startsWith("out")) {
		if(cmp(line, "out") != 0) {
			writeln(line[4..line.length]);
		} else {
			log(fileName ~ ": line " ~ to!string(lineNumber) ~ ": 'out' expects a message to output.", LogType.WARN);
		}
	} else if (line.startsWith("in")) {
		if(cmp(line, "in") != 0) {
			string args = line[3..line.length];
			args = strip(args);
			if(args.indexOf(" ") > -1) {
				string name = args[0..args.indexOf(" ")];
				string message = args[args.indexOf(" ")+1..args.length];
				message = strip(message);
				
				foreach(m; match(message, r"@(\S+)")){
					string word = m.hit;
					string* intVariable = (word[1 .. word.length] in variables);
					if(intVariable !is null) {
						replace(message, regex(word[1..word.length]), variables[word[1..word.length]]);
					} else {
						log(fileName ~ ": line " ~ to!string(lineNumber) ~ ": '" ~ word ~ "' is not defined.", LogType.WARN);
					}
				}

				write("[In] ", message, " > ");
				string input = strip(stdin.readln());
				variables[name] = input;
			} else {
				log(fileName ~ ": line " ~ to!string(lineNumber) ~ ": 'in' expects a variable name and a message to output.", LogType.WARN);
			}
		} else {
			log(fileName ~ ": line " ~ to!string(lineNumber) ~ ": 'in' expects a variable name and a message to output.", LogType.WARN);
		}
	} else if(line.startsWith("#") == false) {
		log(fileName ~ ": line " ~ to!string(lineNumber) ~ ": Textual doesn't know what '" ~ line ~ "' means.", LogType.WARN);
	}
}

string readFile(string path) {
	if(exists(path)) {
		return strip(readText(path));
	}

	return null;
}