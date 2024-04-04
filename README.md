# anthropic-api-client: The Playful Java Gateway to Claude AI 🤖

Welcome to `anthropic-api-client`, proudly presented by Int 13 Consulting, your Java beacon into the world of artificial intelligence! This little piece of technology allows you to seamlessly chat with Anthropic's Claude AI, because who said AI interaction couldn't come with a side of fun?

## Getting Started 🚀

To embark on this adventure, you'll need a Claude AI API key. It's the "Open Sesame" to unlocking the mysteries of AI with our Java client.

### Prerequisites 📋

- Java 11 or newer (we like our coffee fresh and our Java updated)
- Your Claude AI API key (reminder: "your-api-key" won't actually work, we've tried)

### Installation 🛠

To get started, clone this repository or download the ZIP. Prepare to integrate AI wonders into your Java applications.

```bash
git clone https://github.com/Int13Consulting/anthropic-api-client.git
cd anthropic-api-client

## Example Usage 📝

Dive into the AI conversation with a classic question. Here's how you can ask Claude about starting a business, leveraging our intuitive Java client:

String apiKey = "your-real-api-key-here"; // Guard this with your life!
String model = "claude-3-opus-20240229"; // The model of your destiny
String apiVersion = "2023-06-01"; // The version of the future

AnthropicAIClient aiClient = new AnthropicAIClient(apiKey, "https://api.anthropic.com", apiVersion);
AnthropicMessage userMessage = new AnthropicMessage(AnthropicAIRole.USER, "How do I start a business?");
AnthropicRequest request = new AnthropicRequest();
request.setModel(model);
request.setMaxTokens(1024);
request.addMessage(userMessage);

AnthropicResponse response = aiClient.submitRequest(request);

System.out.println("Claude's wisdom: " + response.getContent().get(0).getText());

## Contributing 🤝

Your insights and code spells are welcome in this magical realm. Feel free to dive into our issues page for your first quest.

## License 📜

This enchanted tome is distributed under the MIT License. For more details, wave your wand over the LICENSE file.
