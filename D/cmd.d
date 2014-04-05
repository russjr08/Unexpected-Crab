import std.stdio;
import std.string;
import std.file;
import std.path;
import std.conv;
import std.algorithm;
import std.net.curl;

int main(char[][] args){
	writeln("Downloading version.txt...");
	string cmd;
	string currentDirectory = to!string(getcwd());
	auto http = HTTP();
	http.caInfo("cacert.pem");
	string projectVersion = to!string(get("https://raw.github.com/russjr08/Unexpected-Crab/master/version.txt", http));

	writeln("Welcome to GlitchyPrompt!");
	write(currentDirectory ~ " $ ");
	while((cmd = stdin.readln()) !is null) {
		cmd = strip(cmd);

		if(cmp(cmd, "exit") == 0) {
			return 0;
		} else if (cmp(cmd, "russ") == 0) {
			writeln("Russell :O Kappa");
		} else if (cmp(cmd, "help") == 0) {
			writeln("Valid commands:");
			writeln("help: Displays this screen.");
			writeln("cd: Change the current working directory.");
			writeln("ls: List the files in the current directory.");
			writeln("russ: Russjr08. 'nuff said.");
			writeln("read: Display the contents of a file. (buggy)");
			writeln("crab: Display project information.");
			writeln("exit: Exit the program.");
		} else if (cmp(cmd, "cd") == 0) {
			writeln(currentDirectory);
		} else if (cmp(cmd, "ls") == 0) {
			try {
				string[] files;
				int longestFileName = 0;
				foreach(string filename; dirEntries(currentDirectory, SpanMode.shallow)) {
					string fileName = baseName(filename);
					if(fileName.length > longestFileName) {
						longestFileName = fileName.length;
						if(longestFileName > 17) {
							longestFileName = 20;
							fileName = fileName[0 .. 17] ~ "...";
						}
					}
					files ~= fileName;
				}
				
				int index = 0;

				foreach(string filename; files) {
					string fileName = baseName(filename);
					index++;
					string spaces = "";
					for(int i = fileName.length; i < longestFileName + 1; i++) {
						spaces ~= " ";
					}
					write(fileName ~ spaces);
					if(index == 4) {
						index = 0;
						writeln("");
					}
				}
				writeln("");
			} catch (Exception ex)  {
				writeln("Couldn't display all the files in that directory.");
			}
			
		} else if (cmp(cmd, "crab") == 0) {
			writeln("");
			writeln("Unexpected Crab");
			writeln("---------------");
			writeln("An any language project with no goals.");
			writeln("Version: " ~ projectVersion);
			writeln("");
		} else if (cmd.indexOf(" ") > -1) {
			string label = cmd[0 .. cmd.indexOf(" ")];
			string arg = cmd[cmd.indexOf(" ") + 1 .. cmd.length];
			if(cmp(label, "read") == 0){
				if(exists(arg)) {
					writeln(readText(arg));
				} else if (exists(buildPath(currentDirectory, arg))) {
					writeln(readText(buildPath(currentDirectory, arg)));
				} else {
					writeln("'" ~ arg ~ "' doesn't exist.");
				}
			} if(cmp(label, "cd") == 0){
				if(cmp(arg, "..") == 0 || cmp(arg, "../") == 0) {
					if(endsWith(currentDirectory, "/")) {
						currentDirectory = currentDirectory[0 .. currentDirectory.length - 1];
					} else if(endsWith(currentDirectory, "\\")) { 
						currentDirectory = currentDirectory[0 .. currentDirectory.length - 1];
					}
					if(currentDirectory.indexOf("/") != -1) {
						currentDirectory = currentDirectory[0 .. lastIndexOf(currentDirectory, "/")];
					} else if(currentDirectory.indexOf("\\") != -1) {
						currentDirectory = currentDirectory[0 .. lastIndexOf(currentDirectory, "\\")];
					}
					currentDirectory ~= "\\";
				} else if(cmp(arg, ".") == 0 || cmp(arg, "./") == 0) {
					currentDirectory = currentDirectory; //lol
				} else {
					if (exists(buildPath(currentDirectory, arg)) && isDir(buildPath(currentDirectory, arg))) {
						currentDirectory = buildPath(currentDirectory, arg);
					} else if(exists(arg) && isDir(arg)) {
						currentDirectory = arg;
					} else {
						writeln("'" ~ arg ~ "' doesn't exist or isn't a directory.");
					}
				}
			} else if (cmp(label, "russ") == 0) {
				int count;
				try {
					count = to!int(arg);
				} catch {
					count = 1;
				}

				for(int i = 0; i < count; i++) {
					writeln("Russell :O Kappa");
				}
			} else {
				writeln("'" ~ label ~ "' was not recognized as a valid command.");
			}
		} else {
			writeln("'" ~ cmd ~ "' was not recognized as a valid command.");
		}

		write(currentDirectory ~ " $ ");
	}

	return 0;
}