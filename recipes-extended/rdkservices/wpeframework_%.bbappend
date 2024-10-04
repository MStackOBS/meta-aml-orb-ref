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

do_install_append() {
   # Insert line that sets an environment variable required to resolve the issue with SD video not being displayed full screen
   sed -i '/Environment="RDKSHELL_SHOW_SPLASH_SCREEN=1"/i\ExecStartPre=/bin/systemctl set-environment VIDEO_RENDER_FORCE_FULLSCREEN=1\n' ${D}${systemd_unitdir}/system/wpeframework.service

   # Reduce the time the splash image is displayed on startup
   sed -i 's/RDKSHELL_SHOW_SPLASH_TIME_IN_SECONDS=30/RDKSHELL_SHOW_SPLASH_TIME_IN_SECONDS=10/' ${D}${systemd_unitdir}/system/wpeframework.service
   sed -i 's/\/www\/amlresidentapp\/static\/images\/splash.jpg/\/home\/root\/lxresui\/static\/images\/splash\/rdk_splash.png/' ${D}${systemd_unitdir}/system/wpeframework.service

   # T4H RCU HOME key
   sed -i 's/"keyCode": 88, "mapped": { "keyCode": 70, "modifiers": \["ctrl"\]/"keyCode": 88, "mapped": { "keyCode": 36, "modifiers": \[""\]/' ${D}${sysconfdir}/rdkshell_keymapping.json

   # Bluetooth mode T4H RCU HOME key
   sed -i 's/"keyCode": 102, "mapped": { "keyCode": 77,/"keyCode": 102, "mapped": { "keyCode": 36,/' ${D}${sysconfdir}/rdkshell_keymapping.json
   # Bluetooth mode T4H RCU channel up key
   sed -i '/"keyMappings": \[/a \    { "keyCode"\: 104, "mapped"\: \{ "keyCode"\: 236, "modifiers"\: \[] \}\},' ${D}${sysconfdir}/rdkshell_keymapping.json
   # Bluetooth mode T4H RCU channel down key
   sed -i '/"keyMappings": \[/a \    { "keyCode"\: 109, "mapped"\: \{ "keyCode"\: 237, "modifiers"\: \[] \}\},' ${D}${sysconfdir}/rdkshell_keymapping.json

   # Correct key mapping for coloured keycodes for HbbTV
   sed -i 's/"keyCode": 398, "mapped": { "keyCode": 403/"keyCode": 398, "mapped": { "keyCode": 405/' ${D}/etc/rdkshell_keymapping.json
   sed -i 's/"keyCode": 399, "mapped": { "keyCode": 404/"keyCode": 399, "mapped": { "keyCode": 406/' ${D}/etc/rdkshell_keymapping.json
   sed -i 's/"keyCode": 400, "mapped": { "keyCode": 405/"keyCode": 400, "mapped": { "keyCode": 403/' ${D}/etc/rdkshell_keymapping.json
   sed -i 's/"keyCode": 401, "mapped": { "keyCode": 406/"keyCode": 401, "mapped": { "keyCode": 404/' ${D}/etc/rdkshell_keymapping.json

   # Delete key codes that are mapped to the Back key
   sed -i '/"keyCode": 407, "mapped": { "keyCode": 8,/d' ${D}/etc/rdkshell_keymapping.json
   sed -i '/"keyCode": 470, "mapped": { "keyCode": 8,/d' ${D}/etc/rdkshell_keymapping.json
}

