DOCKER_COMPOSE ?= `which docker-compose`
GRADLEW ?= `pwd`/gradlew

.PHONY: run
run:
	$(GRADLEW) bootRun

.PHONY: build
build:
	$(GRADLEW) build

.PHONY: test
test:
	$(GRADLEW) test

.PHONY: compose
compose:
	$(DOCKER_COMPOSE) up -d

.PHONY: decompose
decompose:
	$(DOCKER_COMPOSE) stop
