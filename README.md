# GUI Testing

Some testing for LectureQuest GUI.

## How to use
### Create the object:

```
FLProgress progressBar = new FLProgress(500, 1, 5);
```

### To add to a layour or pane:
Call the getStackPane() method to return the stack containing the slider and progress bar.
```
progressBar.getStackPane();
```

### .CSS stylesheet
Ensure the style.css file is stored at the location: ```../resources/style.css``` (in relation to the file that calls creates the FLProgress object.)
