### AWS Management & Governance

```
A company is launching a new internal platform for managing multiple independent projects. Each project will require its own dedicated AWS account for isolation. The company needs a solution that automates account creation, applies mandatory security guardrails, and centrally manages shared networking resources such as VPNs and subnets for the accounts. The solution must minimize manual effort and ensure compliance with security standards.

Which solution will meet these requirements with the LEAST operational overhead?

Use AWS Control Tower to automate account provisioning. Create a dedicated networking account with a centralized VPC. Use AWS Resource Access Manager (AWS RAM) to share subnets with project accounts. Enforce security guardrails by using AWS Control Tower guardrails.

 AWS Control Tower simplifies account setup with built-in security guardrails. It minimizes operational overhead by automating VPC sharing and guardrail enforcement through AWS RAM.
```

```
An AWS Organization has an OU with multiple member accounts in it. The company needs to restrict the ability to launch only specific Amazon EC2 instance types. How can this policy be applied across the accounts with the least effort?

Create an SCP with a deny rule that denies all but the specific instance types

To apply the restrictions across multiple member accounts you must use a Service Control Policy (SCP) in the AWS Organization. The way you would do this is to create a deny rule that applies to anything that does not equal the specific instance type you want to allow.
```

```
A retail company operates a multi-tier application that includes a web server layer running on Amazon EC2 instances and a database layer hosted on Amazon RDS. The company is preparing for an annual sales event and anticipates a significant surge in traffic to its application. The operations team wants to monitor the performance of the EC2 instances and database, analyzing metrics with a granularity of 1 minute to ensure quick detection of bottlenecks during the event.

What should the solutions architect do to meet this requirement?

Enable detailed monitoring on all EC2 instances and use Amazon CloudWatch metrics for analysis.

detailed monitoring provides metrics at 1-minute intervals, which allows the operations team to quickly detect and analyze potential bottlenecks during the sales event. CloudWatch natively supports metrics for both EC2 and RDS.
```

```
A financial institution is designing the architecture for a new data processing platform on AWS. The institution uses organizational units (OUs) in AWS Organizations to manage its accounts. To comply with regulatory requirements, all Amazon EC2 instances must include a compliance-level tag with values of compliant or noncompliant. IAM users must not be allowed to create EC2 instances without this tag or modify the tag after creation.

Which combination of steps will meet these requirements? (Select TWO.)

In AWS Organizations, create a tag policy to enforce the use of the compliance-level tag with the required values. Attach the tag policy to the appropriate OU to ensure EC2 instances adhere to the tagging requirements.
In AWS Organizations, create a service control policy (SCP) to deny the creation of EC2 instances if the compliance-level tag is not specified. Attach the SCP to the appropriate OU.