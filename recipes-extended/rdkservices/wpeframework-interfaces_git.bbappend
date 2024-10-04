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

#SRC_URI_append = " ${DTVKIT_GIT}/DTV-Service.git;protocol=${DTVKIT_GIT_PROTOCOL};subpath=interface;destsuffix=dtv;name=dtv;branch=aml_rdk5_main"
SRC_URI_append = " ${OBS_GIT}/DTV-Service.git;protocol=${OBS_GIT_PROTOCOL};subpath=interface;destsuffix=dtv;name=dtv;branch=main"
SRC_URI_append = " file://dtv_ids.patch"

SRCREV_FORMAT = "_dtv"
#SRCREV_dtv = "b7207c002540c14979190c2c12589207a1ad777c"
#SRCREV_dtv = "329a53eda478cb7cabc48d238f794f272a9fccdb"
SRCREV_dtv = "6986c4b29a741b148cba42497bac59a0ff50c561"

do_configure_prepend() {
   cp -a ${WORKDIR}/dtv/* ${WORKDIR}/git
}

do_install_append() {
   # Generate markdown file for the DTV service
   ${STAGING_BINDIR_NATIVE}/python3-native/python3 ${WORKDIR}/recipe-sysroot-native/usr/sbin/JsonGenerator/JsonGenerator.py --docs -i ${S}/interfaces/json/ -j ${S}/interfaces/ -I ${S} -o ${WORKDIR} --verbose ${S}/jsonrpc/DTV.json
}

