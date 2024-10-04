########################################################################
# Copyright © 2022 Ocean Blue Software Ltd (www.oceanbluesoftware.co.uk)
#  This document is the CONFIDENTIAL property of Ocean Blue Software Ltd.
########################################################################

IMAGE_INSTALL_remove = "dtvkit-release-prebuilt rmfapp"

# ORB HbbTV modules
IMAGE_INSTALL_append = " \
    orb-platform \
    orb \
    orb-browser-plugin \
"
