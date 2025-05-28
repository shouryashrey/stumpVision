#!/bin/bash

# Set Kafka installation path
KAFKA_DIR="../../kafka"
ZOOKEEPER_LOG="$KAFKA_DIR/logs/zookeeper.out"
KAFKA_LOG="$KAFKA_DIR/logs/kafka.out"

# Functions to start and stop services
start_kafka() {
    echo "Starting Zookeeper..."
    nohup "$KAFKA_DIR/bin/zookeeper-server-start.sh" "$KAFKA_DIR/config/zookeeper.properties" > "$ZOOKEEPER_LOG" 2>&1 &  
    sleep 5  # Give Zookeeper time to start

    echo "Starting Kafka..."
    nohup "$KAFKA_DIR/bin/kafka-server-start.sh" "$KAFKA_DIR/config/server.properties" > "$KAFKA_LOG" 2>&1 &
    
    echo "Kafka and Zookeeper started."
}

stop_kafka() {
    echo "Stopping Kafka..."
    "$KAFKA_DIR/bin/kafka-server-stop.sh"

    echo "Stopping Zookeeper..."
    "$KAFKA_DIR/bin/zookeeper-server-stop.sh"
    
    echo "Kafka and Zookeeper stopped."
}

status_kafka() {
    echo "Checking running processes..."
    jps | grep -E "Kafka|QuorumPeerMain"
}

# Command-line argument handling
case "$1" in
    start)
        start_kafka
        ;;
    stop)
        stop_kafka
        ;;
    status)
        status_kafka
        ;;
    restart)
        stop_kafka
        sleep 3
        start_kafka
        ;;
    *)
        echo "Usage: $0 {start|stop|restart|status}"
        exit 1
        ;;
esac
