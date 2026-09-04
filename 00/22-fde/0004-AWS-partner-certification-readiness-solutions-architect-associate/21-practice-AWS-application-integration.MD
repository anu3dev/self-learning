### AWS Application Integration

```
There are two applications in a company: a sender application that sends messages containing payloads, and a processing application that receives messages containing payloads. The company wants to implement an AWS service to handle messages between these two different applications. The sender application sends on average 1,000 messages each hour and the messages depending on the type sometimes take up to 2 days to be processed. If the messages fail to process, they must be retained so that they do not impact the processing of any remaining messages.

Which solution meets these requirements and is the MOST operationally efficient?

Provide an Amazon Simple Queue Service (Amazon SQS) queue for the sender and processor applications. Set up a dead-letter queue to collect failed messages.

Amazon Simple Queue Service (SQS) is a fully managed message queuing service that enables you to decouple and scale microservices, distributed systems, and serverless applications. SQS eliminates the complexity and overhead associated with managing and operating message-oriented middleware and empowers developers to focus on differentiating work.
```

```
A company is launching a new photo processing service that uses machine learning (ML) models to analyze and tag images. The service consists of independent microservices for different types of image processing tasks. Each ML model loads approximately 500 MB of data from Amazon S3 into memory at startup.
Users will submit images through a RESTful API, which can handle individual or batch requests. Traffic patterns are unpredictable, with peaks during marketing campaigns and minimal usage during off-hours. The company needs a scalable and cost-effective solution to manage this workload.

Which solution will meet these requirements?

Send the API requests to an Amazon Simple Queue Service (Amazon SQS) queue. Deploy the ML models as Amazon Elastic Container Service (Amazon ECS) services that read messages from the queue. Use auto scaling for ECS to adjust capacity based on queue length.

This solution effectively decouples the API from the backend processing with SQS, ensuring scalability during peaks. ECS services handle the asynchronous nature of requests, and auto scaling adjusts resources based on queue traffic.
```

```
Question 28
Incorrect
A web application allows users to upload photos and add graphical elements to them. The application offers two tiers of service: free and paid. Photos uploaded by paid users should be processed before those submitted using the free tier. The photos are uploaded to an Amazon S3 bucket which uses an event notification to send the job information to Amazon SQS.

How should a Solutions Architect configure the Amazon SQS deployment to meet these requirements?

Use a separate SQS Standard queue for each tier. Configure Amazon EC2 instances to prioritize polling for the paid queue over the free queue.
```

```
A logistics company processes real-time sensor data from delivery vehicles to optimize routes and track vehicle health. The current architecture includes an Auto Scaling group of Amazon EC2 instances for ingesting and storing sensor data, and a separate Auto Scaling group for analyzing and generating route optimizations based on this data.

The company has observed performance issues during peak delivery hours when the rate of data ingestion is significantly higher than the analysis and processing rate. The company wants to ensure that both systems can scale independently, and no data is lost during scaling events.

Which solution will meet these requirements?

Use two Amazon Simple Queue Service (Amazon SQS) queues: one for data ingestion and one for route analysis. Configure the EC2 instances to poll their respective queues and scale the Auto Scaling groups based on the ApproximateNumberOfMessages metric in each queue.
```

```
Question 55
Correct
A fintech company is modernizing its payments processing system to adopt a serverless microservices architecture. The company wants to decouple its services and implement an event-driven architecture to support a publish/subscribe (pub/sub) model. The system needs to notify multiple downstream services when payment events occur, ensuring scalability and low operational overhead.

Which solution will meet these requirements MOST cost-effectively?


Configure an Amazon SNS topic to receive payment events from an AWS Lambda function. Set up multiple subscribers, such as Lambda functions, to process the events.

SNS is a fully managed pub/sub messaging service that supports high-throughput, scalable delivery to multiple subscribers, which aligns with the company's requirements.
```

```
An eCommerce application consists of three tiers. The web tier includes EC2 instances behind an Application Load balancer, the middle tier uses EC2 instances and an Amazon SQS queue to process orders, and the database tier consists of an Auto Scaling DynamoDB table. During busy periods customers have complained about delays in the processing of orders. A Solutions Architect has been tasked with reducing processing times.

Which action will be MOST effective in accomplishing this requirement?

Use Amazon EC2 Auto Scaling to scale out the middle tier instances based on the SQS queue depth.
```

```
A company is working with a strategic partner that has an application that must be able to send messages to one of the company’s Amazon SQS queues. The partner company has its own AWS account.

How can a Solutions Architect provide least privilege access to the partner?

Update the permission policy on the SQS queue to grant the sqs:SendMessage permission to the partner’s AWS account.

Amazon SQS supports resource-based policies. The best way to grant the permissions using the principle of least privilege is to use a resource-based policy attached to the SQS queue that grants the partner company’s AWS account the sqs:SendMessage privilege.
```