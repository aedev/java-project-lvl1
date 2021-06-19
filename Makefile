install: clean
	./gradlew install
run-dist:
	./build/install/app/bin/app
check-updates:
	./gradlew dependencyUpdates
make lint:
    ./gradlew checkstyleMain
build:
    ./gradlew clean build