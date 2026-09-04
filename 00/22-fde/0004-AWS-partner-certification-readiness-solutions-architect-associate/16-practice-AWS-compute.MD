### AWS Compute

```
A solutions architect is creating a system that will run analytics on financial data for several hours a night, 
5 days a week. The analysis is expected to run for the same duration and cannot be interrupted once it is 
started. The system will be required for a minimum of 1 year. 

What should the solutions architect configure to ensure the EC2 instances are available when they are needed? 

`On-Demand Capacity Reservations` - By creating Capacity Reservations, you ensure that you always have access to EC2 capacity when you need it, for as long as you need it. You can create Capacity Reservations at any time, without entering a one-year or three-year term commitment, and the capacity is available immediately.

- Capacity Reservations
	Reserve capacity, not a discount.
	Capacity is reserved in a specific AZ.
	No commitment.
	Can be created/cancelled as needed.
	No billing discount.

- Zonal Reserved Instances
	1-year or 3-year commitment.
	Associated with a specific AZ.
	Provides capacity reservation + billing discount.
	Default limit: 20 per AZ.

- Regional Reserved Instances
	1-year or 3-year commitment.
	No specific AZ capacity reservation.
	Provides billing discount.
	Default limit: 20 per Region.

- Savings Plans
	Commitment-based pricing.
	Provides billing discount.
	No capacity reservation.
	No instance limit
```

```
A persistent database must be migrated from an on-premises server to an Amazon EC2 instances. The database requires 64,000 IOPS and, if possible, should be stored on a single Amazon EBS volume. Which solution should a Solutions Architect recommend?

Create a Nitro-based Amazon EC2 instance with an Amazon EBS Provisioned IOPS SSD (i01) volume attached. Provision 64,000 IOPS for the volume.


Amazon EBS volume types can be broadly grouped into:

General Purpose SSD: gp3, gp2
Provisioned IOPS SSD: io2 Block Express, io2, io1


1. General Purpose SSD
	gp3
		Durability: 99.8%–99.9%
		Annual failure rate: 0.1%–0.2%
		Volume size: 1 GiB – 16 TiB
		Max IOPS: 16,000
		Max throughput: 1,000 MiB/s
		EBS Multi-Attach: ❌ Not supported
		Boot volume: ✅ Supported
		Use cases:
			Low-latency interactive applications
			Development and test environments
	gp2
		Durability: 99.8%–99.9%
		Annual failure rate: 0.1%–0.2%
		Volume size: 1 GiB – 16 TiB
		Max IOPS: 16,000
		Max throughput: 250 MiB/s
		EBS Multi-Attach: ❌ Not supported
		Boot volume: ✅ Supported
		Use cases:
			General-purpose workloads
			Low-latency applications
			Development and testing
2. Provisioned IOPS SSD
	io2 Block Express - Designed for mission-critical, high-performance workloads.
		Durability: 99.999%
		Annual failure rate: 0.001%
		Volume size: 4 GiB – 64 TiB
		Max IOPS: 256,000
		Max throughput: 4,000 MiB/s
		EBS Multi-Attach: ❌ Not supported
		Use cases:
			Workloads requiring sub-millisecond latency
			Sustained high IOPS
			More than 64,000 IOPS
			Up to 1,000 MiB/s throughput
	io2
		Durability: 99.999% (higher durability than gp3/gp2)
		Volume size: 4 GiB – 64 TiB
		Max IOPS: 64,000+
		Max throughput: 1,000 MiB/s+
		EBS Multi-Attach: ❌ Not supported
		Use cases:
			Mission-critical applications
			High-performance databases
			I/O-intensive workloads
	io1
		Durability: 99.8%–99.9%
		Annual failure rate: 0.1%–0.2%
		Volume size: 4 GiB – 16 TiB
		Max IOPS: 64,000+
		Max throughput: 1,000 MiB/s+
		EBS Multi-Attach: ✅ Supported
		Use cases:
			I/O-intensive workloads
			Databases requiring sustained IOPS
			Workloads requiring more than 16,000 IOPS
```

```
A media processing company is migrating its on-premises application to the AWS Cloud. The application processes high volumes of videos and generates large output files during the workflow.

The company requires a scalable solution to handle an increasing number of video processing jobs. The solution should minimize manual intervention, simplify job orchestration, and eliminate the need to manage infrastructure. Operational overhead must be kept to a minimum.

Which solution will fulfill these requirements with the LEAST operational overhead?


Use AWS Batch to run video processing jobs. Use AWS Step Functions to manage the workflow. Store the processed files in Amazon S3.
```

```
A financial services company operates multiple internal services across various AWS accounts. The company uses AWS Organizations to manage these accounts and needs a centralized security appliance in a networking account to inspect all inter-service communication between AWS accounts. The solution must ensure secure and efficient routing of traffic through the security appliance.

Which solution will meet these requirements?

Deploy a Gateway Load Balancer (GWLB) in the networking account to route traffic to the security appliance. Configure the service accounts to send traffic to the GWLB by using a Gateway Load Balancer endpoint in each service account.

GWLB is specifically designed to simplify the deployment of security appliances. Using GWLB endpoints in service accounts ensures efficient routing and centralized inspection of traffic.
```

```
Amazon EC2 instances in an Auto Scaling group. The application stores temporary training data on attached Amazon Elastic Block Store (Amazon EBS) volumes. The company seeks recommendations to optimize costs for the EC2 instances, the Auto Scaling group, and the EBS volumes with minimal manual intervention.

Which solution will meet these requirements with the MOST operational efficiency?


Configure AWS Compute Optimizer to provide cost optimization recommendations for the EC2 instances, the Auto Scaling group, and the EBS volumes.

AWS Compute Optimizer offers actionable insights for cost optimization across EC2 instances, Auto Scaling groups, and EBS volumes with minimal operational overhead.

```

```
A logistics company is running a containerized application on an Amazon Elastic Kubernetes Service (Amazon EKS) cluster with Amazon EC2 instances as the worker nodes. The application includes a management dashboard that uses Amazon DynamoDB for real-time tracking data and a reporting service that stores large datasets in Amazon S3.

The company needs to ensure that the EKS Pods running the management dashboard can access only Amazon DynamoDB, and the EKS Pods running the reporting service can access only Amazon S3. The company uses AWS Identity and Access Management (IAM) for access control.

Which solution will meet these requirements?


Create separate IAM roles with policies for Amazon S3 and DynamoDB access. Use Kubernetes service accounts with IAM Role for Service Accounts (IRSA) to assign the AmazonS3FullAccess policy to the reporting service Pods and the AmazonDynamoDBFullAccess policy to the management dashboard Pods.


IAM Role for Service Accounts (IRSA) allows the assignment of IAM roles directly to Kubernetes service accounts, which the Pods use to assume permissions. This solution enables fine-grained access control, ensuring that the Pods for the management dashboard can access only DynamoDB and the Pods for the reporting service can access only S3.
```

```
A Solutions Architect has deployed an application on several Amazon EC2 instances across three private subnets. The application must be made accessible to internet-based clients with the least amount of administrative effort.

How can the Solutions Architect make the application available on the internet?


Create an Application Load Balancer and associate three public subnets from the same Availability Zones as the private instances. Add the private instances to the ALB.


To make the application instances accessible on the internet the Solutions Architect needs to place them behind an internet-facing Elastic Load Balancer. The way you add instances in private subnets to a public facing ELB is to add public subnets in the same AZs as the private subnets to the ELB. You can then add the instances and to the ELB and they will become targets for load balancing.
```

```
A company runs an application on six web application servers in an Amazon EC2 Auto Scaling group in a single Availability Zone. The application is fronted by an Application Load Balancer (ALB). A Solutions Architect needs to modify the infrastructure to be highly available without making any modifications to the application.

Which architecture should the Solutions Architect choose to enable high availability?


Modify the Auto Scaling group to use two instances across each of three Availability Zones.




ALB	- Distributes incoming traffic
Target Group - Keeps track of EC2 instances/targets and health
ASG	- Maintains/scales the number of EC2 instances
EC2	- Actually runs your application
```

```
A company runs a critical data analysis job every Friday evening. The job processes large datasets and requires at least 2 hours to complete without interruptions. The job is stateful and needs reliable compute resources. The company wants to minimize operational overhead while ensuring the job runs as scheduled.

Which solution will meet these requirements?


Configure the job as a containerized task and run it on AWS Fargate using Amazon ECS. Schedule the task using Amazon EventBridge Scheduler.

AWS Fargate provides a serverless compute engine for containers, ensuring no interruptions. EventBridge Scheduler offers an easy way to schedule tasks without requiring manual intervention.
```

```
A financial services company runs a trading application on a Kubernetes cluster hosted in its on-premises data center. Due to a recent surge in trading activity, the on-premises infrastructure can no longer support the increased load. The company plans to migrate the trading application to the AWS Cloud using an Amazon Elastic Kubernetes Service (Amazon EKS) cluster.

The company wants to minimize the operational overhead by avoiding management of the underlying compute infrastructure for the new AWS architecture.

Which solution will meet these requirements with the LEAST operational overhead?

Use AWS Fargate to provide the compute capacity for the EKS cluster. Create a Fargate profile and deploy the application using the profile.

AWS Fargate eliminates the need to provision or manage EC2 instances, allowing the company to run pods without managing the underlying infrastructure. This greatly reduces operational overhead and meets the company’s requirements.
```

```
Question 52
Correct
A company runs containerized applications for many application workloads in an on-premise data center. The company is planning to deploy containers to AWS and the chief architect has mandated that the same configuration and administrative tools must be used across all containerized environments. The company also wishes to remain cloud agnostic to safeguard against the impact of future changes in cloud strategy.

How can a Solutions Architect design a managed solution that will align with open-source software?


Launch the containers on Amazon Elastic Kubernetes Service (EKS) and EKS worker nodes.


Amazon EKS is a managed service that can be used to run Kubernetes on AWS. Kubernetes is an open-source system for automating the deployment, scaling, and management of containerized applications. Applications running on Amazon EKS are fully compatible with applications running on any standard Kubernetes environment, whether running in on-premises data centers or public clouds. This means that you can easily migrate any standard Kubernetes application to Amazon EKS without any code modification.

This solution ensures that the same open-source software is used for automating the deployment, scaling, and management of containerized applications both on-premises and in the AWS Cloud.

