### steps
- install python 3.10
- install postman
- install vs code
- activate copilot in vs code
- install python extension in vs code

### resources
- postman url - https://api.waip.wiprocms.com/v1.1/skills/completion/query
- metod type - POST
- authentication - Bearer token
- token url - https://apps.waip.wiprocms.com/WelcomePage
- body -
```json
{
  "messages": [
    {
      "content": "Capital of India?",
      "role": "user"
    }
  ],
  "skill_parameters": {
    "model_name": "gpt-4",
    "retrieval_chain": "custom",
    "max_output_tokens": 500,
    "temperature": 1,
    "top_p": 1,
    "frequency_penalty": 0,
    "presence_penalty": 0,
    "emb_type": "openai",
    "top_k": 5,
    "return_sources": true
  },
  "stream_response": false
}
```
- headers -
```json
{
  "accept": "application/json",
  "content-type": "application/json",
}
```