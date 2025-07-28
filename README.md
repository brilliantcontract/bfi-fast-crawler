# BFI Fast Crawler

This project is a simple Java application that collects contact information from a list of websites. It reads domain names from `urls.txt`, downloads each site and extracts:

- e‑mail addresses
- phone numbers
- the contact page URL
- links to popular social networks
- the domain country inferred from the website URL

The extracted data is written to `websites.csv` in CSV format.

## Building

A Java 8+ JDK and Maven are required. To build the executable JAR run:

```bash
mvn package
```

The build creates `target/bfi-fast-crawler-1.0.0.jar` and copies runtime dependencies to `target/lib/`.

## Running

After building, execute the crawler with:

```bash
java -jar target/bfi-fast-crawler-1.0.0.jar
```

The program prints the discovered information to the console and appends it to `websites.csv`.

## Configuration

- **urls.txt** – list of website URLs/domains to crawl (one per line).
- **urls-authors-verified.txt** and **urls-irs-verified.txt** – sample alternative URL lists.

The crawler will automatically attempt a direct HTTP request first. If it fails, it falls back to the [ScrapeNinja](https://scrapeninja.p.rapidapi.com/) API as implemented in `Downloader`.
If a page responds with `<title>Client Challenge</title>`, the crawler also retries that request using ScrapeNinja.

## Testing

Unit tests can be executed with:

```bash
mvn test
```

The provided test is disabled by default because it requires network access to ScrapeNinja.

## Manual verification

Use [galeinai.com](https://galeinai.com/authsearch/sm/index.html) to confirm that
all social links were extracted correctly from a website. When comparing the
generated `websites.csv` with another CSV file, the diff tool at
[textcompare.org](https://www.textcompare.org/csv) can highlight any
differences.

