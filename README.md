The FileSystem project implements a file system using the composite design pattern. It can be viewed as a tree structure made up of types that inherit a base type, and it can represent a single part or a whole hierarchy of objects. This project provides basic operations for managing files and directories.

Composite Design Pattern
The composite design pattern allows clients to treat individual objects and compositions of objects uniformly. In our case, a directory can contain both files and subdirectories, allowing for a hierarchical structure that can be navigated and manipulated seamlessly.

Features
1. Create Files and Directories: You can create files and directories in the file system.
2. List Contents: List the contents of a directory.
3. Delete Files and Directories: Remove files and directories from the file system.
4. Search for Files: Search for a file within the file system.
5. Navigation: Navigate through directories and move back to the parent directory.
