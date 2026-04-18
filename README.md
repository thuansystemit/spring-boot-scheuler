# Spring Boot Scheduler

A practical reference project that explains how to design, configure, and operate reliable background task scheduling in Spring Boot applications for real-world production systems.

This repository focuses on concepts, architecture, and best practices for building schedulers that are safe, scalable, observable, and suitable for single-instance as well as multi-instance deployments.

---

## Overview

Task scheduling is a core requirement in many backend systems:

- Sending emails and notifications
- Generating reports
- Cleaning up expired data
- Synchronizing systems
- Running periodic business jobs

This project documents how scheduling works in Spring Boot, the common pitfalls, and how to evolve from simple local jobs to distributed, production-grade schedulers.

---

## Goals

- Understand how scheduling works in Spring Boot
- Learn different scheduling strategies and when to use them
- Configure thread pools for concurrent jobs
- Externalize scheduling configuration using properties
- Enable/disable jobs by environment
- Handle failures, retries, and logging
- Run schedulers safely in multi-instance deployments using distributed locks
- Apply production best practices for reliability and performance

---

## Key Topics Covered

- Enabling scheduling in Spring Boot
- Fixed rate vs fixed delay vs cron scheduling
- Deep understanding of cron expressions
- Custom task scheduler thread pool configuration
- Dynamic scheduling at runtime
- Conditional scheduling by environment or property
- Distributed scheduling using ShedLock
- Observability, monitoring, and logging
- Exception handling strategies
- Testing scheduled jobs
- Production best practices

---

## Architecture Focus

This project emphasizes scheduler architecture rather than code:

- How the scheduler thread pool operates
- How tasks are queued and executed
- How long-running tasks affect other jobs
- How to prevent duplicate job execution in clustered environments
- How to design idempotent scheduled tasks

---

## Single Instance vs Multi Instance

A critical topic in this project is understanding the difference between:

- Running schedulers in a single application instance
- Running schedulers across multiple instances behind a load balancer

It explains why distributed locking is required and how to prevent duplicate execution.

---

## Reliability & Safety

You will learn how to make scheduled tasks:

- Idempotent
- Safe to retry
- Observable through logs and metrics
- Configurable without code changes
- Isolated from impacting application performance

---

## Monitoring & Observability

Guidance on how to:

- Log scheduler executions properly
- Measure execution time
- Detect failures
- Integrate with monitoring tools

---

## Production Best Practices

This repository highlights common mistakes and how to avoid them:

- Using the default scheduler thread
- Running heavy tasks without a dedicated pool
- Hardcoding cron expressions
- Ignoring exception handling
- Running schedulers without distributed locks in multi-instance deployments

---

## ho This Project Is For

- Backend developers working with Spring Boot
- Engineers building microservices
- Teams deploying applications with multiple instances
- Anyone who needs reliable background job processing

---
