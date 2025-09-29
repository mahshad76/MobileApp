# Mobile App
This mobile application provides a seamless shopping experience by offering two distinct views managed via a Bottom Navigation Bar: the Product Catalog and the Shopping Cart.
<video src="https://github.com/user-attachments/assets/a35549b6-47e0-429d-9db4-43e7c83f0c53" controls></video>

# ✨ Core Features

### 1. Product Catalog (View 1)

This primary view presents a dynamic, browseable **catalog** of items, currently focused on **digital devices**, sourced from an external service.

#### 1.1. External Data Source
Product inventory is dynamically consumed from the public **[RestfulApi](https://restful-api.dev/)**.

#### 1.2. Browsing
Users can efficiently navigate and explore all available products displayed in an intuitive list format.

#### 1.3. Quick Add
Each product tile includes a dedicated **'Add to Cart' action button**, enabling users to instantly transfer items to their shopping basket.

### 2. Shopping Cart (View 2)

Accessible via the bottom navigation bar, this view serves as the user's shopping basket.

#### 2.1. Local Persistence
Items added from the Catalog are maintained and **persisted locally** within this view, ensuring data integrity across sessions.

