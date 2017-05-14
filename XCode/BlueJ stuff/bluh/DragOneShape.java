import objectdraw.*;
import java.awt.*;

public class DragOneShape extends FrameWindowController {
private FilledRect rect1;
private FilledRect rect2;
private Location lastPoint;
private boolean rect1Selected = false; private boolean rect2Selected = false;
public void begin() {
rect1 = new FilledRect (10, 10, 30, 30, canvas); rect2 = new FilledRect (50, 50, 30, 30, canvas);
}
public void onMousePress (Location point) { if (rect1.contains (point)) {
rect1Selected = true; }
if (rect2.contains (point)) { rect2Selected = true;
}
lastPoint = point; }
public void onMouseDrag (Location point) { double dx = point.getX() - lastPoint.getX(); double dy = point.getY() - lastPoint.getY(); if (rect1Selected) {
rect1.move (dx, dy); }
if (rect2Selected) { rect2.move (dx, dy);
}
lastPoint = point; }
public void onMouseRelease (Location point) { if (rect1Selected) {
rect1Selected = false; }
else if (rect2Selected) { rect2Selected = false;
} }
}