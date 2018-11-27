# CheckVersion
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
</br>To check application's version **Library**

## What is CheckVersion?
You can use it for getting a version of an application.</br> 
If you have already published an your application on market, you can get the market version.</br>


## Gradle
[![Download](https://api.bintray.com/packages/eltoryn7/maven/check-market-version/images/download.svg)](https://bintray.com/eltoryn7/maven/check-market-version/_latestVersion)
```gradle
dependencies{
  minSdkVersion 15
  targetSdkVersion 28
  
  ....
  implementation 'com.lsh.checkversion:check-market-version:x.x.x'
}
```

## How to use
* Menifset
```manifest
  <uses-permission android:name="android.permission.INTERNET" />
```
* Java
```java
  CheckModule module = new CheckModule(context); // Constructor with context.
  module.getMarketVer(); // Get an application's market version.
  module.getApplicationVer(); // Get an application's package version(current version).
  module.isVersionSame(); // Market ver and Current ver equals or not.
```
```kotlin

```
