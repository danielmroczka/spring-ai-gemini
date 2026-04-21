# Spring AI + Gemini Flash Demo

## Purpose
This is a simple Spring Boot app that sends a user message to Google's Gemini model and returns the model response.

- API endpoint: `GET /api/ask?message=...`
- Response shape: `{ "question": "...", "answer": "..." }`

## Configure `GEMINI_API_KEY`
Set your Gemini API key in an environment variable named `GEMINI_API_KEY` before starting the app.

PowerShell (current terminal session):

```powershell
$env:GEMINI_API_KEY="your_api_key_here"
```

PowerShell (persist for your user profile; open a new terminal after this):

```powershell
setx GEMINI_API_KEY "your_api_key_here"
```

## Where the app takes the key from
The key is read from environment variable substitution in `src/main/resources/application.properties`:

```properties
spring.ai.openai.api-key=${GEMINI_API_KEY}
```

The app uses the Spring AI OpenAI-compatible Gemini endpoint:

```properties
spring.ai.openai.base-url=https://generativelanguage.googleapis.com/v1beta/openai/
spring.ai.openai.chat.options.model=gemini-flash-latest
```

## Run and execute
Prerequisites:
- Java 21
- Internet access
- Valid `GEMINI_API_KEY`

Run the app with Gradle wrapper:

```powershell
.\gradlew.bat bootRun
```

Call the endpoint from another terminal:

```powershell
Invoke-RestMethod -Method Get -Uri "http://localhost:8080/api/ask?message=Hello"
```

Or in a browser:

- `http://localhost:8080/api/ask?message=Hello`

