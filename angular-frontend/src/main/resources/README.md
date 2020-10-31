# Step-by-step

## Create front end
ng new angular-book-client in resources/frontend

## Edit angular.json
"outputPath": "../../static"

## Create proxy.conf.json
{
  "/": {
    "target": "http://localhost:8080",
    "secure": false
  }
}

## Edit package.json
"start": "ng serve --proxy-config proxy.conf.json"

## In command line
npm run-script start
npm run-script build (to build angular project in "/static" folder for testing)

## Edit build.gradle
task buildFrontend(type: Exec) {
    if (System.getProperty('os.name').toLowerCase(Locale.ROOT).contains('windows')) {
        commandLine 'cmd', '/c', 'cd src/main/frontend && npm run-script build && xcopy build\\* ..\\resources\\static\\ /Y /E '
    } else {
        commandLine 'sh', '-c', 'cd src/main/frontend && npm run-script build && cp -r build/* ../resources/static/'
    }
}

build.dependsOn buildFrontend
bootJar.dependsOn buildFrontend