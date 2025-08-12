# Text RPG Grid Movement

This is a simple text-based grid movement demo similar to RPG Maker movement.

## Controls

- Arrow keys: Move the `@` character up, down, left, or right within the grid (when running in a real terminal).
- `W`, `A`, `S`, `D`: Move up, left, down, or right when running in the fallback text mode.
- `q`: Quit the game.

## Running

Run the script with Python:

```bash
python main.py
```

The game will try to use Python's built-in `curses` module for an arrow-key interface. If the terminal doesn't support curses (for example, when running in certain IDEs or non-interactive environments), the script automatically falls back to a simple text mode using the `WASD` controls.

## Playing in the Browser

Open `index.html` in a modern web browser to play a JavaScript version of the same grid movement game without needing Python.
