# Running Apache Kafka with Docker

Instead of installing Kafka manually, we'll run it inside a Docker container.

This is the recommended approach for local development because it is:

- Easy to set up
- Easy to remove
- Platform independent
- Matches how many production environments are managed

---

# Project Structure

Create a new folder inside your project.

```text
kafka-microservices/
│
├── docker/
│     └── docker-compose.yml
│
├── order-service/
├── inventory-service/
├── payment-service/
└── notification-service/
```

---

# docker-compose.yml

Create a file named:

```text
docker/docker-compose.yml
```

Paste the following configuration.

```yaml
version: '3.8'

services:

  kafka:
    image: apache/kafka:latest
    container_name: kafka

    ports:
      - "9092:9092"

    environment:
      KAFKA_NODE_ID: 1
      KAFKA_PROCESS_ROLES: "broker,controller"

      KAFKA_LISTENERS: "PLAINTEXT://:9092,CONTROLLER://:9093"
      KAFKA_ADVERTISED_LISTENERS: "PLAINTEXT://localhost:9092"

      KAFKA_CONTROLLER_LISTENER_NAMES: "CONTROLLER"

      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: "CONTROLLER:PLAINTEXT,PLAINTEXT:PLAINTEXT"

      KAFKA_CONTROLLER_QUORUM_VOTERS: "1@localhost:9093"

      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
      KAFKA_TRANSACTION_STATE_LOG_REPLICATION_FACTOR: 1
      KAFKA_TRANSACTION_STATE_LOG_MIN_ISR: 1

      KAFKA_LOG_DIRS: "/tmp/kraft-combined-logs"

      CLUSTER_ID: "MkU3OEVBNTcwNTJENDM2Qk"

    restart: unless-stopped
```

---

# Start Kafka

Open a terminal inside the **docker** folder.

Run:

```bash
docker compose up -d
```

Docker downloads the Kafka image (first time only) and starts the broker in the background.

---

# Verify the Container

Run:

```bash
docker ps
```

Expected output:

```text
CONTAINER ID   IMAGE                  NAME
xxxxxxxxxxxx   apache/kafka:latest    kafka
```

If the Kafka container is listed, it is running successfully.

---

# Verify the Logs

Run:

```bash
docker logs kafka
```

If everything starts correctly, you'll see Kafka startup logs indicating that the broker is ready.

---

# What Happens Internally?

When the container starts, the following sequence occurs:

```text
Docker
    │
    ▼
Kafka Process Starts
    │
    ▼
Creates Cluster Metadata
    │
    ▼
Starts Controller
    │
    ▼
Starts Broker
    │
    ▼
Opens Port 9092
    │
    ▼
Kafka Ready
```

---

# Open a Shell Inside the Container

Run:

```bash
docker exec -it kafka bash
```

You are now inside the Kafka container.

---

# Verify Kafka Installation

Run:

```bash
ls /opt/kafka/bin
```

You should see Kafka utilities such as:

```text
kafka-topics.sh
kafka-console-producer.sh
kafka-console-consumer.sh
kafka-configs.sh
kafka-storage.sh
...
```

---

# Create a Kafka Topic

Inside the container, execute:

```bash
/opt/kafka/bin/kafka-topics.sh \
--create \
--topic order-created \
--bootstrap-server localhost:9092 \
--partitions 3 \
--replication-factor 1
```

Expected output:

```text
Created topic order-created.
```

---

# Verify the Topic

Run:

```bash
/opt/kafka/bin/kafka-topics.sh \
--describe \
--topic order-created \
--bootstrap-server localhost:9092
```

Expected output (similar):

```text
Topic: order-created

PartitionCount: 3
ReplicationFactor: 1

Partition: 0
Leader: 1

Partition: 1
Leader: 1

Partition: 2
Leader: 1
```

This confirms:

- Topic created successfully
- Three partitions exist
- Replication factor is 1
- Broker 1 is the leader

---

# Start a Producer

Open a terminal inside the Kafka container.

Run:

```bash
/opt/kafka/bin/kafka-console-producer.sh \
--topic order-created \
--bootstrap-server localhost:9092
```

Now type the following messages:

```text
Order 101 Created
Order 102 Created
Order 103 Created
```

Each line is published as a Kafka event.

---

# Start a Consumer

Open another terminal.

Enter the Kafka container:

```bash
docker exec -it kafka bash
```

Run:

```bash
/opt/kafka/bin/kafka-console-consumer.sh \
--topic order-created \
--bootstrap-server localhost:9092 \
--from-beginning
```

Expected output:

```text
Order 101 Created
Order 102 Created
Order 103 Created
```

The `--from-beginning` option instructs Kafka to consume all retained messages from the earliest available offset.

---

# Test Real-Time Streaming

Go back to the producer terminal.

Publish another event:

```text
Order 104 Created
```

Immediately switch to the consumer terminal.

You should see:

```text
Order 104 Created
```

No polling.

No REST calls.

No HTTP requests.

Just real-time event streaming.

---

# How It Works Internally

```text
Producer
    │
    ▼
Kafka Broker
    │
    ▼
order-created Topic
    │
    ▼
Consumer
```

Every message published by the producer is immediately available to consumers subscribed to the topic.

---

# Key Takeaways

| Concept | Explanation |
|----------|-------------|
| **Docker Compose** | Starts Kafka with a single command. |
| **Kafka Container** | Runs the Kafka broker inside Docker. |
| **docker ps** | Lists running containers. |
| **docker logs kafka** | Displays Kafka startup logs. |
| **docker exec** | Opens a shell inside the Kafka container. |
| **kafka-topics.sh** | Creates, lists, and describes Kafka topics. |
| **kafka-console-producer.sh** | Publishes messages manually. |
| **kafka-console-consumer.sh** | Consumes messages manually. |
| **--from-beginning** | Reads all retained messages from the earliest offset. |
| **Real-Time Streaming** | Consumers receive new events immediately after they are published. |

---
