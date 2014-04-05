#!/usr/bin/env python3

import curses # unix only
import time

class Player:
    def __init__(self, name):
        self.name = name
        self.isdead = False
    def take_action(self, action):
        if (math.random() < .1):
            die()
            return "You have died."

    def die(self):
        self.isdead = True

logo = """
WELCOME TO UNEXPECTED CRAB %s!
          ___________
         | mwahahaha |
         ,-----------'
   __       __
  / <`     '> \\
 (  / O   O \  )
  \(_ _\_/_ _)/
(\ `-/     \-' /)
 "===\     /==="
  .==')___(`==. 
 ' .='     `=.

"""
story = """
WHAT DO YOU THINK YOU ARE DOING IN MY LAIR???
I AM THE KING OF CRABS. BOW DOWN BEFORE ME.
MWAHAHAHAHAHAHA... FOR THIS DISGRESSION, I
SENTENCE YOU TO DEATH!
"""
skull = """
                     .ed\"\""" \"""$$$$be.
                   -"           ^""**$$$e.
                 ."                   '$$$c
                /                      "4$$b
               d  3                      $$$$
               $  *                   .$$$$$$
              .$  ^c           $$$$$e$$$$$$$$.
              d$L  4.         4$$$$$$$$$$$$$$b
              $$$$b ^ceeeee.  4$$ECL.F*$$$$$$$
  e$""=.      $$$$P d$$$$F $ $$$$$$$$$- $$$$$$
 z$$b. ^c     3$$$F "$$$$b   $"$$$$$$$  $$$$*"      .=""$c
4$$$$L        $$P"  "$$b   .$ $$$$$...e$$        .=  e$$$.
^*$$$$$c  %..   *c    ..    $$ 3$$$$$$$$$$eF     zP  d$$$$$
  "**$$$ec   "   *ce""    $$$  $$$$$$$$$$*    .r" =$$$$P""
        "*$b.  "c  *$e.    *** d$$$$$"L$$    .d"  e$$***"
          ^*$$c ^$c $$$      4J$$$$$% $$$ .e*".eeP"
             "$$$$$$"'$=e....$*$$**$cz$$" "..d$*"
               "*$$$  *=%4.$ L L$ P3$$$F $$$P"
                  "$   "$*ebJLzb$e$$$$$b $P"
                    %..      4$$$$$$$$$$ "
                     $$$e   z$$$$$$$$$$%
                      "*$c  "$$$$$$$P"
                       .\"""*$$$$$$$$bc
                    .-"    .$***$$$\"""*e.
                 .-"    .e$"     "*$c  ^*b.
          .=*\"\"""    .e$*"          "*bc  "*$e..
        .$"        .z*"               ^*$e.   "*****e.
        $$ee$c   .d"                     "*$.        3.
        ^*$E")$..$"                         *   .ee==d%
           $.d$$$*                           *  J$$$e*
            \"\"\"""                              "$$$"

"""
player = False

def ui(rootwin):
    global logo, player
    rootwin.clear()
    rootwin.addstr(logo % player.name.upper())
    rootwin.refresh()

    time.sleep(3)
    rootwin.move(7,6)
    rootwin.addstr("@   @")
    rootwin.move(14,0)
    rootwin.refresh()

    time.sleep(2)
    for char in story:
        rootwin.addstr(char)
        rootwin.refresh()
        time.sleep(.1)
    time.sleep(3)
    rootwin.clear()
    for line in skull.split("\n"):
        rootwin.addstr(line + "\n")
        rootwin.refresh()
        time.sleep(.2)
    time.sleep(5)

def main():
    global player
    player = Player(raw_input("What is your name?\n> "))
    curses.wrapper(ui)

if __name__ == '__main__':
    main()
