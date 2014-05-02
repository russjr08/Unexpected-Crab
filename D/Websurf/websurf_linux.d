/*
	This will only run on Windows, most likely!
	Changes will have to be made for Linux/OSX support.
*/

import std.stdio;
import std.string;
import std.file;
import std.path;
import std.array;
import std.conv;
import std.algorithm;
import std.net.curl;
import std.process;
import std.regex;

int main(char[][] args) {
	// Downloading
	auto http = HTTP();
	http.caInfo("cacert.pem");

	// Clear the screen.
	auto pid = system("cls");
	wait(pid);

	string input;

	// Take in any input after "Navigate ->".
	write("Navigate -> ");

	while((input = stdin.readln()) !is null) {
		pid = system("cls");
		wait(pid);
		string pageContents = to!string(get(input, http));

		auto removeTags = regex(r"<[^>]*>", "g");
		auto removeScripts = regex(r"<script[\d\D]*?>[\d\D]*?</script>", "g");
		auto removeStyle = regex(r"<style[\d\D]*?>[\d\D]*?</style>", "g");
		auto removeDoubleSpaces = regex(r"  ", "g");
		auto removeTabs = regex(r"\t", "g");

		//writeln(m.hit[6 .. m.hit.length - 1]);
		foreach(m; matchAll(pageContents, r"<a[\d\D]*?>[\d\D]*?</a>") ) {
			//writeln(m.hit);
			foreach(m2; matchAll(m.hit, r"href=['""]?([^'"" >]+)") ) {
				string linkMatch = m.hit;
				linkMatch = replaceAll(linkMatch, removeTags, "") ~ " [-> '" ~ m2.hit[6..m2.hit.length-1] ~ "']";
				pageContents = pageContents.replace(m.hit, linkMatch);
			}
		}
		
		pageContents = strip(replaceAll(pageContents, removeScripts, ""));
		pageContents = strip(replaceAll(pageContents, removeStyle, ""));
		pageContents = strip(replaceAll(pageContents, removeTags, ""));
		pageContents = strip(replaceAll(pageContents, removeDoubleSpaces, ""));
		pageContents = strip(replaceAll(pageContents, removeTabs, ""));

		string[] lines = splitLines(pageContents);
		foreach(string line; lines) {
			if(strip(line).length != 0) {
				writeln(strip(line));
				writeln();
			}
		}

		writeln();
		write("Navigate -> ");
	}

	return 0;
}

auto system(string cmd) {
	return spawnProcess(["system_win", cmd]);
}