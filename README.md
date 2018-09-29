# tl;dr

Alexa skill, written in Kotlin, to fetch TriMet arrivals for bus times in Portland, OR.

# Try it out

You can try out the live skill [here](https://www.amazon.com/David-Merrick-Portland-Bus/dp/B01NB9LCZK/ref=sr_1_1?ie=UTF8&qid=1538191917&sr=8-1&keywords=portland+bus).

# Usage

In the Lambda's handler field, set the handler to: 
```
com.merricklabs.portlandbus.PortlandBusStreamHandler
```

Set the following environment variables:
- `SKILL_ID`: Your Alexa skill's id.
- `DYNAMODB_ENDPOINT`: Endpoint for DynamoDB. For example, in the Oregon region I'm using, it's https://dynamodb.us-west-2.amazonaws.com.
- `DYNAMODB_REGION`: Region for DynamoDB. For example, `us-west-2`.
- `DYNAMODB_TABLE`: DynamoDB table.
- `TRIMET_APP_ID`: API key for accessing TriMet. Get one [here](https://developer.trimet.org/).
- `INVOCATION_NAME`: Name used to invoke your skill. Mine is `Portland Bus`. 

## Recommended settings
- 512 MB of memory is plenty.
- Timeout of 5s seems to work well and eliminate any DynamoDB calls prematurely timing out.

# Reference

[This guide](https://alexa-skills-kit-sdk-for-java.readthedocs.io/en/latest/Developing-Your-First-Skill.html) was very helpful in getting up to speed on writing an Alexa skill in Java. I subsequently rewrote it in Kotlin.

# Running locally

Use [localstack](https://github.com/localstack/localstack) to mock out the DynamoDB endpoints.
