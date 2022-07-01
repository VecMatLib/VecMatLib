# VecMatLib

Hexagon VecMatLib provides simple structures for vectors and matrices and an implementation of all their basic operations.

## Project goals

- Implement basic operations for vectors and matrices using the fastest and most simple method.
- Vectors and matrices are immutable. All operations do not alter the object on which they are invoked, they return a new one instead.
- All operations implemented by vectors and matrices are intended to work similarly to java basic operators.
- Compatible with the latest version of Java (Java 18 at the time of writing).

## Support the project

VecMatLib was developed by a single person.

Initially a university project, later completed and turned into a full project.

[![ko-fi](https://ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/X8X87EZ87)

If you wish to contribute to the project, bug fixes, code improvements and unit test coverage changes are welcome!

## Official documentation

Official documentation is hosted with Github Pages at [hexagonnico.github.io/VecMatLib](https://hexagonnico.github.io/VecMatLib)

## Include VecMatLib in your project

VecMatLib is uploaded as a Github Package.

Add the following dependency to your `pom.xml` file to include VecMatLib in your project:

```
	<dependency>
		<groupId>io.github.hexagonnico</groupId>
		<artifactId>vecmatlib</artifactId>
		<version>2.0</version>
	</dependency>
```

Then run the command `mvn clean install` to install the package to your local repository.
