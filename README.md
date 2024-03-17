# Dickname Generator Server
https://dickname.serje3.ru

## Overview

The Dickname Generator Server is a unique, lightweight server application designed to generate dickname for any names. This innovative tool is perfect for writers, poets, lyricists, or anyone in need of finding the perfect rhyme to complement a name in their creative projects. The server operates at `https://dickname.serje3.ru/api/generate/dickname`, providing an easy-to-use API endpoint for generating rhymes.

## Features

- **Name Rhyming**: Input a name, and the server returns a rhyme, making it easier to craft songs, poems, or any content that requires rhyming.
- **Simple API**: The server exposes a straightforward POST endpoint, making it accessible to developers and non-developers alike.
- **Fast and Reliable**: Built with performance in mind, the server responds quickly, ensuring your creative process isn't hindered by waiting times.

## How to Use

To use the Rhyme Generator Server, simply make a POST request to the endpoint with the name you want to find a rhyme for. Here's a quick example using `curl`:

```bash
curl --location 'https://dickname.serje3.ru/api/generate/dickname' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Витя"
}'
```