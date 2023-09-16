# StyleLibrary
don't mind the name, this is actually a keyboard library

I developed this keyboard in order to use it on my "My Word" and "Manga Reader" projects. This keyboard will not guess what you want to input, it makes sense when you want a keyboard that will be used in a word cards application. In addition, this keyboard is very easy to use, you can slide your finger in order to select a letter. It has a vertical version and a horizontal version.

![ss](https://github.com/warriorWorld/MangaReader/blob/master/app/screenshot/ss5.jpg) 

On this vertical version of this keyboard, you select the letter by sliding your finger from 4 or 3 directions.

***
![github](https://github.com/warriorWorld/VideoCrawler/blob/master/app/screenshot/translate1.jpg) 

---
## Import the library:

```
    implementation 'com.github.warriorWorld:StyleLibrary:1.1.7'
```

## And call it like this:

```java
  private void showKeyboardDialog() {
        final KeyBoardDialog dialog = new KeyBoardDialog(this);
        dialog.setOnKeyboardChangeListener(new OnKeyboardChangeListener() {
            @Override
            public void onChange(String res) {
                //this will be called whenever users input a letter
            }

            @Override
            public void onFinish(String res) {
               //this will be called when users click Enter
            }
        });
        dialog.setOnKeyboardListener(new OnKeyboardListener() {
            @Override
            public void onOptionsClick() {
            }

            @Override
            public void onQuestionClick() {
            }
        });
        dialog.show();
    }
```

## If you want the horizontal version of this keyboard, then call it like this:

```java
 private void showLandsacpeKeyboardDialog() {
        final LandscapeKeyBoardDialog dialog = new LandscapeKeyBoardDialog(this);
        dialog.setKeyBorad26Listener(new English26KeyBoardView.KeyBorad26Listener() {
            @Override
            public void inputFinish(String s) {
               //this will be called when users click Enter
            }

            @Override
            public void closeKeyboard() {

            }
        });
        dialog.show();
    }
```
