# Mobile App
This mobile application provides a seamless shopping experience by offering two distinct views managed via a Bottom Navigation Bar: the Product Catalog and the Shopping Cart.
<video src="https://github.com/user-attachments/assets/a35549b6-47e0-429d-9db4-43e7c83f0c53" controls></video>

# ✨ Core Features

- **Product Catalog (View 1)**: This primary view presents a dynamic, browseable **catalog** of items, currently focused on **digital devices**, sourced from an external service.

  - **External Data Source**: Product inventory is dynamically consumed from the public **[RestfulApi](https://restful-api.dev/)**.
  - **Browsing**: Users can efficiently navigate and explore all available products displayed in an intuitive list format.
  - **Quick Add**: Each product tile includes a dedicated **'Add to Cart' action button**, enabling users to instantly transfer items to their shopping basket.
    
- **Shopping Cart (View 2)**: Accessible via the bottom navigation bar, this view serves as the user's shopping basket.

  - **Local Persistence**: Items added from the Catalog are maintained and **persisted locally** within this view, ensuring data integrity across sessions.

# 🏗️ Architecture
This project is built on the MVVM architectural pattern, which ensures a clear separation of concerns across the application.

- View: The user interface is implemented using traditional Android XML layouts (the classic View system).

- ViewModel: Manages UI-related data, handles user actions, and coordinates all interactions with the Repository layer.

- Model: Defines the core data structures and entities used throughout the application (network responses, database objects, etc.).

# 🧩 Modules
- **app**: The main application module, coordinating navigation and application setup.
- **core**: Contains shared and reusable components essential across the application.
    - **common**: General utility classes, extensions, and common UI components.
    - **data**: Implements **repositories** that define the contract for data access.
    - **database**: Contains local data storage logic (e.g., Room implementation) for data persistence.
    - **model**: Includes data structures and domain objects, modeling the data used by the repositories.
    - **network**: Manages API calls and data fetching from the external **RestfulApi** service (e.g., Retrofit setup).
    - **threading**: Provides components for managing coroutines, dispatchers, and background operations.
- **feature**: Contains distinct, encapsulated business logic modules.
    - **home**: Implements the main user flows, providing fragments for the **product catalog** and the **shopping cart**, along with their respective ViewModels.

# ⚙️ Technologies and Libraries

The application leverages a modern Android development stack:

* **Language:** Kotlin
* **UI Framework:** Android XML Layouts (Traditional View System, built on Views)
* **Asynchronous Operations:** Kotlin Coroutines for managing background and non-blocking tasks.
* **Local Data Persistence (Relational):** Room for an abstraction layer over SQLite, managing structured local data.
* **Local Persistence (Key-Value/Protobuf):** DataStore (Preferences & Proto) for modern, thread-safe, and asynchronous data storage of simple key-value pairs and complex typed objects.
* **HTTP Client:** Retrofit for a type-safe API client.
* **Networking:** OkHttp for efficient network requests, including the Logging Interceptor for debugging.
* **Serialization/Deserialization:** Kotlinx Serialization for converting JSON payloads into Kotlin data classes.
* **Dependency Injection:** Hilt (built on Dagger) for a clean, scalable, and standardized DI setup.
* **Unit Testing:** JUnit 5 (Jupiter API & Engine) and Truth for asserting conditions.
* **Android Testing:** AndroidX Test libraries and Robolectric for running Android tests locally on the JVM.
* **Coroutines Testing:** Kotlinx Coroutines Test for handling asynchronous logic in unit tests.

# 🎨 Design

The UI design is inspired by the following Figma community design: [Shopping App for iOS or Android](https://www.figma.com/design/C2KQFYc7HcojktQHp9xtBZ/Shopping-app-%F0%9F%93%A6--Community-?node-id=0-4&p=f&t=bKthlMGscGgwVimM-0).

