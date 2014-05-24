import std.stdio;
import std.string;
import std.file;
import std.path;
import std.array;
import std.conv;
import std.algorithm;
import std.net.curl;
import std.random;

int main(char[][] args) {
	auto http = HTTP();
	http.caInfo("cacert.pem");

	if(args.length > 1) {
		int arg = 0;
		try {
			arg = to!int(args[1]);
			writeln("Attempting to find a valid YouTube video id...");
		} catch (Exception e) {
			writeln("Expected an integer as the first argument!");
			return 1;
		}

		for(int i = 0; i < arg; i++) {
			string id = generateID();
			string pageContents = to!string(get("http://youtube.com/watch?v=" ~ id, http));

			if(pageContents.indexOf("This video is unavailable.") != -1) {
				writeln(id ~ " is an invalid youtube video.");
			} else {
				writeln("OMG "~id);
				break;
			}			
		}
	} else {
		writeln("Expected an integer as the first argument!");
	}

	return 0;
}

string generateID(){
	string chars = "abcdefghijklmnopqestuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789_-";
	string result = "";

	for(int i = 0; i < 11; i++) {
		int index = uniform(0, chars.length);
		result ~= chars[index..index+1];
	}

	return result;
}