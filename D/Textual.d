import std.stdio;
import std.string;
import std.file;
import std.conv;
import std.utf;
import std.regex;
import std.array;

enum LogType { WARN, ERROR, INFO };
string[string] variables;
string[string] blocks;
bool creatingBlock = false;
string currentBlock = "";

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
	if(!creatingBlock) {
		if(line.startsWith("out")) {
			if(cmp(line, "out") != 0) {
				writeln(parseVariables(line[4..line.length], lineNumber, fileName));
			} else {
				log(fileName ~ ": line " ~ to!string(lineNumber) ~ ": 'out' expects a message to output.", LogType.WARN);
			}
		} else if (line.startsWith("in")) {
			if(cmp(line, "in") != 0) {
				string args = line[3..line.length];
				args = strip(args);
				if(args.indexOf(" ") > -1) {
					string name = "(@" ~ args[0..args.indexOf(" ")] ~ ")";
					string message = args[args.indexOf(" ")+1..args.length];
					message = parseVariables(message, lineNumber, fileName);
					write("", message, " > ");
					string input = strip(stdin.readln());
					variables[name] = input;
				} else {
					log(fileName ~ ": line " ~ to!string(lineNumber) ~ ": 'in' expects a variable name and a message to output.", LogType.WARN);
				}
			} else {
				log(fileName ~ ": line " ~ to!string(lineNumber) ~ ": 'in' expects a variable name and a message to output.", LogType.WARN);
			}
		} else if (line.startsWith("gotoblock")) {
			if(cmp(line, "gotoblock") != 0) {
				string blockName = line[10..line.length];
				string* block = (blockName in blocks);
				if(block !is null) {
					int blockLineNumber = lineNumber;
					foreach(string blockLine; splitLines(blocks[blockName])) {
						blockLineNumber++;
						processLine(blockLine, blockLineNumber, fileName);
					}
				} else {
					log(fileName ~ ": line " ~ to!string(lineNumber) ~ ": '" ~ blockName ~ "' is not defined.", LogType.WARN);
				}
			} else {
				log(fileName ~ ": line " ~ to!string(lineNumber) ~ ": 'gotoblock' expects a block name.", LogType.WARN);
			}
		} else if (line.startsWith("if")) {
			if(cmp(line, "if") != 0) {

			} else {
				log(fileName ~ ": line " ~ to!string(lineNumber) ~ ": 'if' expects a condition and a statement.", LogType.WARN);
			}
		} else if(line.startsWith("#") == false && line.length != 0 && line.startsWith("block") == false  && line.startsWith("endblock") == false && creatingBlock == false) {
			log(fileName ~ ": line " ~ to!string(lineNumber) ~ ": Textual doesn't know what '" ~ line ~ "' means.", LogType.WARN);
		}
	}

	if (line.startsWith("block")) {
		if(!creatingBlock) {
			creatingBlock = true;
			if(cmp(line, "block") != 0) {
				currentBlock = line[6..line.length];
			} else {
				log(fileName ~ ": line " ~ to!string(lineNumber) ~ ": 'block' expects a block name.", LogType.WARN);
			}
		} else {
			log(fileName ~ ": line " ~ to!string(lineNumber) ~ ": You can't define a block here because you're already within a block.", LogType.WARN);
		}
	} else if (line.startsWith("endblock")) {
		if(creatingBlock) {
			creatingBlock = false;
		} else {
			log(fileName ~ ": line " ~ to!string(lineNumber) ~ ": You can't end a block here because you're not within a block.", LogType.WARN);
		}
	}

	if(creatingBlock) {
		string* block = (currentBlock in blocks);
		if(line.startsWith("block") == false) blocks[currentBlock] = (block !is null ? blocks[currentBlock] : "") ~ '\n' ~ line;
	}
}

string readFile(string path) {
	if(exists(path)) {
		return strip(readText(path));
	}

	return null;
}

string parseVariables(string message, int lineNumber, string fileName) {
	message = strip(message);
	foreach(m; match(message, r"\(@(\S+)\)")){
		string word = m.hit;
		string* intVariable = (word in variables);
		if(intVariable !is null) {
			message = message.replace(word, variables[word]);
		} else {
			log(fileName ~ ": line " ~ to!string(lineNumber) ~ ": '" ~ word ~ "' is not defined.", LogType.WARN);
		}
	}
	return message;
}
