# Notification API

Simple REST service to implement push notifications via WebSockets. This application exports a public broker for consumers so they can subscribe to a topic and start receiving messages implementing the STOMP protocol.

This particular implementation allows Vite applications to consume the '/admins' topic. If you want to make some changes make sure to modify the WebSocketConfiguration class.

## Installation

Follow these steps to install and run the project:

1. Clone the repository: `git clone https://github.com/EzeSosa/notification-api.git`
2. Navigate to the project directory: `cd notification-api`
3. Build the project using Gradle: `gradle build`
4. Run the project: `gradle run`
5. Test the API using Postman or another HTTP client at `http://localhost:9090`