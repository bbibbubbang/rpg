"""Simple grid movement game with terminal fallback.

This module attempts to run a small grid‑based movement demo using the
``curses`` library for arrow‑key input. If the program is executed in an
environment that doesn't support curses (for example, when stdin/stdout is
not a TTY), it falls back to a plain text mode controlled with ``WASD``
commands.
"""

import curses
import sys

GRID_WIDTH = 10
GRID_HEIGHT = 10


def run_curses(stdscr):
    """Play the game using the curses interface."""
    curses.curs_set(0)
    stdscr.nodelay(True)
    stdscr.keypad(True)

    player_x = GRID_WIDTH // 2
    player_y = GRID_HEIGHT // 2

    while True:
        stdscr.clear()
        for y in range(GRID_HEIGHT):
            for x in range(GRID_WIDTH):
                char = '@' if (x, y) == (player_x, player_y) else '.'
                stdscr.addch(y, x, char)
        stdscr.refresh()

        keys = set()
        while True:
            key = stdscr.getch()
            if key == -1:
                break
            keys.add(key)

        if ord('q') in keys:
            break

        dy = (curses.KEY_DOWN in keys) - (curses.KEY_UP in keys)
        dx = (curses.KEY_RIGHT in keys) - (curses.KEY_LEFT in keys)

        new_x = player_x + dx
        new_y = player_y + dy

        if 0 <= new_x < GRID_WIDTH:
            player_x = new_x
        if 0 <= new_y < GRID_HEIGHT:
            player_y = new_y

        curses.napms(50)


def run_text():
    """Fallback text mode controlled with WASD keys."""
    player_x = GRID_WIDTH // 2
    player_y = GRID_HEIGHT // 2

    while True:
        # Clear the screen for a simple animation effect. Using ANSI escape
        # codes avoids relying on external commands like ``clear`` which may
        # be unavailable in restricted environments.
        print("\033[H\033[J", end="")
        for y in range(GRID_HEIGHT):
            row = ''.join(
                '@' if (x, y) == (player_x, player_y) else '.'
                for x in range(GRID_WIDTH)
            )
            print(row)

        command = input().strip().lower()
        if command == 'q':
            break
        elif command == 'w' and player_y > 0:
            player_y -= 1
        elif command == 's' and player_y < GRID_HEIGHT - 1:
            player_y += 1
        elif command == 'a' and player_x > 0:
            player_x -= 1
        elif command == 'd' and player_x < GRID_WIDTH - 1:
            player_x += 1


if __name__ == "__main__":
    if sys.stdin.isatty() and sys.stdout.isatty():
        try:
            curses.wrapper(run_curses)
        except curses.error:
            run_text()
    else:
        run_text()
