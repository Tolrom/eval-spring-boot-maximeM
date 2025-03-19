# API Documentation

## Category Endpoints

### Get all categories
**GET** `/api/categories`
- **Response:** Returns a list of all categories.
- **Response Status:** `200 OK`

### Get a category by ID
**GET** `/api/categories/{id}`
- **Path Variable:** `id` (integer) - The ID of the category.
- **Response:** Returns the requested category.
- **Response Status:** `200 OK`

### Add a new category
**POST** `/api/categories/add`
- **Request Body:** A JSON object representing the new category.
  ```json
  {
    "label": "string"
  }
  ```
- **Response:** Returns the created category.
- **Response Status:** `201 Created`

---

## Product Endpoints

### Get all products
**GET** `/api/products`
- **Response:** Returns a list of all products.
- **Response Status:** `200 OK`

### Get a product by ID
**GET** `/api/products/{id}`
- **Path Variable:** `id` (integer) - The ID of the product.
- **Response:** Returns the requested product.
- **Response Status:** `200 OK`

### Add a new product
**POST** `/api/products/add`
- **Request Body:** A JSON object representing the new product.
  ```json
  {
    "name": "string",
    "price": "double",
    "category": {
      "id": "integer" 
    }
  }
  ```
  - **Valid Example:**
      ```json
      {
        "name": "Playstation 5",
        "price": "499.99",
        "category": {
          "id": "6" 
        }
    }
    ```
      - **Returns:**
        ```json
        {
          "id": 3,
          "name": "Playstation 5",
          "price": 499.99,
          "category": {
          "id": 6,
          "label": null
        }
        ```
  - **Not valid Example:**
    ```json
    {
      "name": "A",
      "price": "-15",
    }
    ```
    - **Returns:** 
      ```json
      {
        "price": "Please enter a positive price!",
        "name": "Name length must be between 2 and 50",
        "category": "Must belong to a category!"
      }
      ```
- **Response:** Returns the created product.
- **Response Status:** `201 Created`

