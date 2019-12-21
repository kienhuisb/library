mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file -Dfile=<path-to-file># library
Contains a set of common java classes that I can use in my other programs.

Install into your local maven repsotory with the following command:

mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file -Dfile=<path-to-file>

See this page for more details:

https://maven.apache.org/guides/mini/guide-3rd-party-jars-local.html




		<!-- Fross Library: Custom set of commonly used classes -->
		<dependency>
			<groupId>org.fross.library</groupId>
			<artifactId>library</artifactId>
			<version>2019.12.20</version>
		</dependency>
