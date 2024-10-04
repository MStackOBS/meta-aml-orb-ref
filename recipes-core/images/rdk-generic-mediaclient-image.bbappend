# Copyright © 2024 The DTVKit Open Software Foundation Ltd (www.dtvkit.org)
#
# This file is part of a DTVKit Software Component
# You are permitted to copy, modify or distribute this file subject to the terms
# of the DTVKit 1.0 Licence which can be found in licence.txt or at www.dtvkit.org
#
# THIS CODE AND INFORMATION ARE PROVIDED "AS IS" WITHOUT WARRANTY OF ANY KIND,
# EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES
# OF MERCHANTABILITY AND/OR FITNESS FOR A PARTICULAR PURPOSE.
#
# If you or your organisation is not a member of DTVKit then you have access
# to this source code outside of the terms of the licence agreement
# and you are expected to delete this and any associated files immediately.
# Further information on DTVKit, membership and terms can be found at www.dtvkit.org

IMAGE_INSTALL_remove = "dtvkit-release-prebuilt rmfapp"

# add wlb dtv service as a separate package
IMAGE_INSTALL_append = " dtv-service"

# Include HbbTV if enabled
IMAGE_INSTALL_append = "${@bb.utils.contains('DISTRO_FEATURES', 'hbbtv', ' orb orb-platform orb-browser-plugin', '', d)}"

