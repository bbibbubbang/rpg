import curses

GRID_WIDTH = 10
GRID_HEIGHT = 10


def main(stdscr):
    curses.curs_set(0)
    stdscr.nodelay(False)
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

        key = stdscr.getch()
        if key == ord('q'):
            break
        elif key == curses.KEY_UP and player_y > 0:
            player_y -= 1
        elif key == curses.KEY_DOWN and player_y < GRID_HEIGHT - 1:
            player_y += 1
        elif key == curses.KEY_LEFT and player_x > 0:
            player_x -= 1
        elif key == curses.KEY_RIGHT and player_x < GRID_WIDTH - 1:
            player_x += 1


if __name__ == "__main__":
    curses.wrapper(main)
