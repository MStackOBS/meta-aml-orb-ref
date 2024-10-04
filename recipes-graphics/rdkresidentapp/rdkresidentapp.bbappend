########################################################################
# Copyright © 2022 Ocean Blue Software Ltd (www.oceanbluesoftware.co.uk)
#  This document is the CONFIDENTIAL property of Ocean Blue Software Ltd.
########################################################################

do_install_append() {
   if [ -f ${D}${systemd_unitdir}/system/residentapp.service ]; then
      sed -i 's/Requires=wpeframework.service/& lighttpd.service/' ${D}${systemd_unitdir}/system/residentapp.service
   fi
   if [ -f ${D}/lib/rdk/residentApp.sh ]; then
      sed -i 's/usb\/partnerapps\/appmanagerregistry.conf/etc\/appmanagerregistry.conf/g' ${D}/lib/rdk/residentApp.sh 
   fi
}

