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

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_remove = "${CMF_GIT_ROOT}/rdk/components/generic/dvb/dtv-testapp.git;protocol=${CMF_GIT_PROTOCOL};branch=${CMF_GIT_BRANCH}"
SRC_URI_remove = " file://0001-RSP-2138-fix-playback.patch"

SRC_URI += "${OBS_GIT}/RDK-DTVApp.git;protocol=${OBS_GIT_PROTOCOL};branch=rdk5_orb"
SRC_URI += " file://DTVKit.png"

SRCREV_pn-${PN} = "f2ead11161ba3999bf7eb7b377506ed8aed2e30a"

LICENSE = "RDK & MIT"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=be590d88793604a045627b973ca604e5"

do_install_append() {
   install -m 644 ${WORKDIR}/DTVKit.png ${D}/${DTVAPP_DIR}/assets/images/

   rm ${D}/${DTVAPP_DIR}/create_rdk_release.sh
   rm -r ${D}/lib/
}

