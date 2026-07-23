# General Store Appium Automation Testing Project

## 📱 Overview

This project is a **Mobile Application Automation Testing project** for the **General Store Android application** using **Appium**, **Java**, and **TestNG**.

The project automates the main user flow of the application, including entering user information, selecting a country, choosing gender, adding products to the cart, and completing the checkout process.

The purpose of this project is to practice and demonstrate **mobile automation testing skills** using Appium with Selenium WebDriver concepts.

---

## 🛠️ Tools & Technologies

* **Java**
* **Appium**
* **Selenium WebDriver**
* **TestNG**
* **Maven**
* **Android Emulator / Real Android Device**
* **UiAutomator2**
* **Eclipse IDE**
* **Git & GitHub**

---

## ✅ Test Scenarios

### 1. User Login Test

* Launch the General Store application.
* Enter username.
* Open country dropdown.
* Select a country using scroll functionality.
* Select gender.
* Click "Let's Shop".
* Verify that the product list is displayed.

**Validation:**

* Verify that the "Add to Cart" button is visible.

---

### 2. Add Products To Cart Test

* Add the first product to the cart.
* Add the second product to the cart.
* Take a screenshot after adding products.

---

### 3. Checkout Test

* Open the cart.
* Select the email discount checkbox.
* Click the proceed button.
* Take a screenshot of the final state.
* Close the application.

---

## 📂 Project Structure

```
GeneralStore-Appium-Automation
│
├── src
│   └── StoreApp
│       └── App.java
│
├── MyApp
│   └── General-Store.apk
│
├── screenshots
│   └── Test execution screenshots
│
├── pom.xml
│
└── README.md
```

---

## ⚙️ Setup & Installation

### 1. Clone the repository

```bash
git clone https://github.com/your-username/GeneralStore-Appium-Automation.git
```

### 2. Install project dependencies

Make sure you have:

* Java JDK installed
* Maven installed
* Appium Server installed
* Android SDK configured

Then run:

```bash
mvn clean test
```

---

## 📲 Appium Configuration

The test uses the following capabilities:

```java
platformName = Android

automationName = UiAutomator2

deviceName = HUAWEI 2019

app = General-Store.apk

noReset = false
```

---

## 🚀 Test Execution Flow

1. Start Appium Server.

2. Connect Android device or start emulator.

3. Run the TestNG test cases.

4. Test execution will:

   * Open the application.
   * Perform user actions automatically.
   * Capture screenshots.
   * Generate test results.

---

## 📸 Screenshots

Screenshots are automatically captured during test execution and stored inside:

```
screenshots/
```

They help verify the application state after each major test step.

---

## 🔍 Automation Features Covered

✔ Mobile application automation
✔ Appium driver setup
✔ Android UI automation using UiAutomator2
✔ Finding elements using ID and XPath
✔ Handling dropdown lists with scrolling
✔ Explicit waits using WebDriverWait
✔ TestNG test execution
✔ Assertions for validation
✔ Screenshot capturing
✔ Automated application flow

---

## 📌 Future Improvements

* Add Page Object Model (POM) design pattern.
* Add better test data management.
* Add HTML test reports.
* Add CI/CD integration using GitHub Actions.
* Add more test scenarios.

---

## 👩‍💻 Author

**Eng. Tasneem Tanashat**




