# Auction Coding Challenge

One of the things that the Engineering team at Sortable works on is software that
runs ad auctions, either in the browser or server-side. The goal of this challenge
is to write a program that will run a simple auction, while enforcing data validity.

## Concepts

Sortable manages ads on many different websites. Each site has a different
configuration: which bidders are permitted to bid on ads on that site, and an
auction 'floor' that bids must meet or exceed.

Each bidder also has a configuration. For this challenge we have significantly
reduced the configuration to consist of an adjustment to be applied to each bid
to account for the difference between how much the bidder claims that they'll
pay, and how much they will actually pay, based on historical data.

## Running the auctions

On start-up, your program should load the config file (`config.json`) which lists
all valid sites and bidders, and their respective configurations.

The program should then load the input (JSON) from standard input that contains
a list of auctions to run. Each auction lists the site, which ad units are being
bid on, and a list of bids that have been requested on your behalf.

For each auction, you should find the highest valid bidder for each ad unit, after
applying the adjustment factor. An adjustment factor of -0.01 means that bids are
reduced by 1%; an adjustment of 0.05 would increase them by 5%. (Positive
adjustments are rare in real life, but possible.)
For example, a bid of $0.95 and an adjustment
factor of 0.05 (adjusted to $0.9975) will beat a bid of $1.10 with an adjustment
factor of -0.1 (adjusted to $0.99). When reporting the winners, use the bid
amounts provided by the bidder, rather than the adjusted values.

It is possible that a bidder will submit multiple bids for the same ad unit in
the same auction.

A bid is invalid and should be ignored if the bidder is not permitted to bid on
this site, the bid is for an ad unit not involved in this auction, the bidder
is unknown, or if the *adjusted* bid value is less than the site's floor.

An auction is invalid if the site is unrecognized, or there are no valid bids.
In the case of an invalid auction, just return an empty list of bids.

The output of your program should be a JSON list of auction results printed to [stdout][stdout].
The result of each auction is a list of winning bids. The contents of `output.json`
are an example of valid output. Ensure that when run as above, the **only** output
of your program on stdout is the auction results.

## Inputs

Ensuring that inputs are well-formed (e.g. all fields are present and are of the
expected types) is important, but also uninteresting. You may therefore assume
that all inputs will be well-formed. All numeric values will be 64-bit floats (as
is default for JSON).

## Sample code and Dockerfiles

Sample config, inputs and expected output are included in this repo to help you
test your submission.

Also included are some sample Dockerfiles for various languages, to be used for
building and testing your submission. You may use any other language you are
comfortable with, though keep in mind that the code will be reviewed by a developer.
Rename the appropriate template to `Dockerfile`, or create your own.
By using Docker, you can ensure that we are building and running your
submission with the same toolchain as you.

## Evaluation

Your code will be first evaluated mechanically, running it through various test cases
to check its correctness. Your code will be built and run using these commands:

```bash
$ docker build -t challenge .
$ docker run -i -v /path/to/test/config.json:/auction/config.json challenge < /path/to/test/input.json
```

**Please ensure that your submission can be run this way.**

If your build process requires additional steps, please note them near the top of
your submission's README.md, but the end result must be a Docker image that can be
run using the command above.

After running our tests, the code will be reviewed by a developer. This is an opportunity
for you to demonstrate your knowledge of best practices, as well as your familiarity
with your chosen language, and its library ecosystem.

[stdout]: https://en.wikipedia.org/wiki/Standard_streams#Standard_output_(stdout)
