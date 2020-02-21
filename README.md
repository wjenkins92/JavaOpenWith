# How to get files used with "Open With" on a Mac in Java?

**Step 1: Add an OpenFileHandler** Start by creating and setting an `OpenFileHandler` using `Desktop.getDesktop().setOpenFileHandler()`.

```Java
import java.awt.desktop.OpenFilesEvent;
import java.awt.desktop.OpenFilesHandler;

public class FileHandler implements OpenFilesHandler
{
	...
	public void openFiles (OpenFilesEvent e)
	{
		// Do something with the files using e.getFiles().
		...
	}
	...
}
```

```Java
import java.awt.Desktop;

public class SampleProgram
{
	public static void main (String[] args)
	{
		...
		FileHandler fh = new FileHandler();
		Desktop.getDesktop().setOpenFileHandler(fh);
		...
	}
}
```

**Step 2: Compile** Compile your source code into a `.app` executable. At the terminal execute:

```javapackager -makeall -appclass SampleProgram```

**Step 3: Modify Info.plist** You must modify your application's `Info.plist` and add a key for each file type you want your application to modify. To do this, right click on your `.app` executable and select "Show Package Contents".

![alt text](https://raw.githubusercontent.com/wjenkins92/JavaOpenWith/master/ShowPackageContents.png?token=AITC3AJP5GRD623S2KNQ3FC6KBBHC "Show Package Contents on Mac")

Navigate to `/Contents/` and open `Info.plist` with a text editor. At the end of this file, add a `CFBundleDocumentTypes` key and an array holding each of the file types you want your application to be able to open. For more information, see the Apple Developer's documentation for [CFBundleDocumentTypes](https://developer.apple.com/library/archive/documentation/General/Reference/InfoPlistKeyReference/Articles/CoreFoundationKeys.html#//apple_ref/doc/uid/TP40009249-101685-TPXREF107), [Uniform Type Identifiers](https://developer.apple.com/library/archive/documentation/FileManagement/Conceptual/understanding_utis/understand_utis_intro/understand_utis_intro.html#//apple_ref/doc/uid/TP40001319), and [System-Declared Uniform Type Identifiers](https://developer.apple.com/library/archive/documentation/Miscellaneous/Reference/UTIRef/Articles/System-DeclaredUniformTypeIdentifiers.html#//apple_ref/doc/uid/TP40009259).

Because I want my application to read text (`.txt`) and HTML (`.htm`, `.html`) files, my application's `Info.plist` looks like this:

```xml
<?xml version="1.0" ?>
<!DOCTYPE plist PUBLIC "-//Apple//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd">
<plist version="1.0">
	<dict>
		<key>LSMinimumSystemVersion</key>
		<string>10.9</string>
		<key>CFBundleDevelopmentRegion</key>
		<string>English</string>
		...
		<key>CFBundleDocumentTypes</key>
		<array>
			<dict>
				<key>CFBundleTypeExtensions</key>
				<array>
					<string>txt</string>
				</array>
				<key>CFBundleTypeRole</key>
				<string>Editor</string>
				<key>LSItemContentTypes</key>
				<array>
					<string>public.plain-text</string>
				</array>
			</dict>
			<dict>
				<key>CFBundleTypeExtensions</key>
				<array>
					<string>htm</string>
				</array>
				<key>CFBundleTypeRole</key>
				<string>Editor</string>
				<key>LSItemContentTypes</key>
				<array>
					<string>public.html</string>
				</array>
			</dict>
			<dict>
				<key>CFBundleTypeExtensions</key>
				<array>
					<string>html</string>
				</array>
				<key>CFBundleTypeRole</key>
				<string>Editor</string>
				<key>LSItemContentTypes</key>
				<array>
					<string>public.html</string>
				</array>
			</dict>
		</array>
	</dict>
</plist>
```

Don't forget to save the modified `Info.plist`!

**Step 5: Open With** Now you can open files with the system's context menu item "Open With". The file or files used with "Open With" can be accessed with the `OpenFilesEvent.getFiles()` method.

Right click the file you want to edit. Select Open With → Other.
![alt text](https://raw.githubusercontent.com/wjenkins92/JavaOpenWith/master/OpenWith_Other.png?token=AITC3ANBG5FTJ4S7PS45ETK6KBAXE "Open With on Mac")

Navigate to where your `.app` is stored. Select it, then click Open.
![alt text](https://raw.githubusercontent.com/wjenkins92/JavaOpenWith/master/OpenWith_Choose.png?token=AITC3ANWYWB5LRD65OV5HZC6KBA3A "Choosing our app with Open With")

The file was successfully passed into our program.
![alt text](https://raw.githubusercontent.com/wjenkins92/JavaOpenWith/master/OpenedFile.png?token=AITC3AKYN7NKL7S5N7CGKUC6KBA7K "File was passed to program")
