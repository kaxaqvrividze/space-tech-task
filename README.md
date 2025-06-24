# SpaceTechTask


This project contains Two modules

1. **User Management API Automation**
1. **Reddit API Automation**
---

## User Management API Automation

This project is a **Test Automation Framework** built with **Java**, **RestAssured**, **Cucumber**, and **TestNG**, designed to validate the full **CRUD functionality** of the public API [https://reqres.in](https://reqres.in).

## Features

- Automated testing of `Create`, `Read`, `Update`, and `Delete` operations
- Step definitions written in clean BDD-style using **Cucumber**
- Request/response handling using **RestAssured**
- Assertion management with **TestNG**
- Thread-safe test context handling (for parallel execution)
- Clean project structure for scalability


##  Tech Stack

- **Java 17+**
- **Cucumber** – BDD test syntax (`.feature` files)
- **RestAssured** – HTTP request automation
- **TestNG** – Test assertion and execution framework
- **Maven** – Project build and dependency management
- **Lombok** – Boilerplate reduction
- **ThreadLocal Context** – Stores status code for cross-step validations

## 📁 Project Structure


- **API** client  API client interface and implementation
- **Model** POJOs for request/response
- **Util** Utility classes (e.g., TestContext, Config)
- **Step** Step Definitions (Cucumber glue code)
- **Features** # Cucumber .feature files
---

## 🚀 How to Run the Tests

### 1. Clone the Repository

```bash
git clone https://github.com/kaxaqvrividze/space-tech-task.git
```
### 2. Go to the user-api-test folder
```bash
cd user-api-test
```
### 3. Setup Config.properties
Set your API Key
### 4. Build the Project
```bash
mvn clean install
```
### 5. Run Cucumber Tests
```bash
mvn test
```


#  How to Run Tests by Tag
**Use the --tags option in your test runner configuration or CLI command to run only specific scenarios.**

### Example 1: Run only @Create tests
```bash
mvn test -Dcucumber.filter.tags="@Create"
```
### Example 2: Run all @Update and @Delete tests
```bash
mvn test -Dcucumber.filter.tags="@Update or @Delete"
```
###  Example 3: Run everything except @Read tests
```bash
mvn test -Dcucumber.filter.tags="not @Read"
```

###  Example Scenarios
- Create user with valid data

- Create user with missing fields

- Get existing or non-existent users

- Update users with valid/invalid data

- Delete existing and non-existing users

---
## Reddit API Automation


## Technologies Used

- Java 17
- Appium (UIAutomator2)
- TestNG
- Maven (optional)
- Selenium WebDriver

## Prerequisites

- Java 17 installed
- Android SDK and ADB installed and configured
- Appium Server running at `http://127.0.0.1:4723`
- Physical Android device or emulator connected
- Reddit APK file located at `src/main/resources/reddit.apk` (you can change this path in configuration)


## Configuration

All configurations are stored in `src/main/resources/configuration.properties`:

```properties
appium.server=http://127.0.0.1:4723

platform.name=Android
device.name=Pixel 7
automation.name=UIAutomator2
app.path=src/main/resources/reddit.apk
app.package=com.reddit.frontpage
app.activity=com.reddit.launch.main.MainActivity
app.wait.activity=*
auto.grant.permissions=true
app =APKPath
user.username=your.email@example.com
user.password=yourPassword
```

## Notes
Ensure the APK path in the configuration is correct.
If you encounter SessionNotCreatedException or other errors, verify your Appium version, device/emulator setup, and Android platform version.


---


👨‍💻 Author:
Kakha Kvrividze
