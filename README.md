# Amlogic White Label Box meta layer

This is the meta layer for building DVBCore on the DTVKit Amlogic White Label Box.

Access is required to the Amlogic RDK v5.2.1 release.

To build an image for the WLB, perform the following steps:

* Set up a build environment for the Amlogic RDK v5.2.1 release (based on Ubuntu 18.04 LTS)
* Clone the Amlogic RDK meta layers into a new directory using the repo init/repo sync commands.
* Clone this repo into the same directory as the Amlogic and RDK meta layers
* Run the following commands:
   * `source meta-dtvkit-aml/setup-environment`
   * `bitbake lib32-rdk-generic-mediaclient-image`

