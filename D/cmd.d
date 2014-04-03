import std.stdio;
import std.string;
import std.file;
import std.path;
import std.conv;

int main(char[][] args){
	string cmd;
	string currentDirectory = to!string(getcwd());

	writeln("Welcome to GlitchyPrompt.egg!!1");
	write(currentDirectory ~ " $ ");
	while((cmd = stdin.readln()) !is null) {
		cmd = strip(cmd);

		if(cmp(cmd, "exit") == 0) {
			return 0;
		} else if (cmp(cmd, "russ") == 0) {
			for(int i = 0; i < 10; i++) {
				writeln("RUSS KAPPA");
			}
		} else if (cmp(cmd, "help") == 0) {
			writeln("Valid commands:");
			writeln("help: Displays this screen.");
			writeln("cd: Change the current working directory.");
			writeln("ls: List the files in the current directory.");
			writeln("russ: Russjr08. 'nuff said.");
			writeln("read: Display the contents of a file.");
			writeln("exit: Exit the program.");
		} else if (cmp(cmd, "cd") == 0) {
			writeln(currentDirectory);
		} else if (cmp(cmd, "ls") == 0) {
			try {
				foreach(string fileName; dirEntries(currentDirectory, SpanMode.depth)) {
					writeln(baseName(fileName));
				}	
			} catch (Exception ex)  {
				writeln("Couldn't display all the files in that directory.");
			}
			
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
				if(exists(arg) && isDir(arg)) {
					currentDirectory = arg;
				} else if (exists(buildPath(currentDirectory, arg)) && isDir(buildPath(currentDirectory, arg))) {
					currentDirectory = buildPath(currentDirectory, arg);
				} else {
					writeln("'" ~ arg ~ "' doesn't exist or isn't a directory.");
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