CREATE TABLE IF NOT EXISTS tracked_products (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    url TEXT NOT NULL UNIQUE,
    store TEXT,
    target_price REAL,
    active INTEGER NOT NULL DEFAULT 1,
    created_at TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS price_history (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    tracked_product_id INTEGER NOT NULL,
    price REAL NOT NULL,
    checked_at TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (tracked_product_id)
        REFERENCES tracked_products(id)
);

CREATE INDEX IF NOT EXISTS idx_price_history_product
ON price_history(tracked_product_id);

CREATE INDEX IF NOT EXISTS idx_tracked_products_active
ON tracked_products(active);
