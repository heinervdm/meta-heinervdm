DESCRIPTION = "Open source SIP stack and media stack for presence, im/instant \
               messaging, and multimedia communication"
SECTION = "libs"
HOMEPAGE = "http://www.pjsip.org/"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=477ab0a4c8ca64b482b3f2a365d0fdfa"

DEPENDS = "alsa-lib openssl"
# ffmpeg libsdl(>=1.3.0) libv4l

PARALLEL_MAKE = ""

SRC_URI = "http://www.pjsip.org/release/${PV}/pjproject-${PV}.tar.bz2 "
SRC_URI[md5sum] = "69e68612deaa3c760ec6aac46968c95a"
SRC_URI[sha256sum] = "08a5c5b3f5f263c8938afad4f9338dc9e94f2f9c7b334c2194317c7fab6d794d"

S = "${WORKDIR}/pjproject-${PV}"

inherit autotools pkgconfig

do_configure_prepend() {
        export AR="${HOST_SYS}-ar rv"
        export LD="${CC}"
#        echo "#define PJMEDIA_HAS_VIDEO	1" > pjlib/include/pj/config_site.h
}

do_compile_prepend() {
        oe_runmake dep
}
