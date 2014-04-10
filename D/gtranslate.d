import std.stdio;
import std.conv;

int main(char[][] args) {
	if(args.length == 3) {
		writeln("no");
	} else {
		writeln("Please provde an input and an output language like so: 'gtranslate en fr'.");
	}

	return 0;
}
