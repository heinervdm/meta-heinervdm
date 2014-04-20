CMDLINE_raspberrypi_append = "fbcon=map:10 fbcon=font:VGA8x8 fbcon=rotate:3"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://fbtft.cfg"
SRC_URI += "https://github.com/notro/fbtft/archive/238c3ad645a5a8214ec3190e621958d7d837ca21.zip;name=fbtft"
#SRC_URI += "https://raw.github.com/notro/spi-bcm2708/17c21df2c44414f47097721746d6d1e1bbac3e8e/spi-bcm2708.c;name=spi"
SRC_URI += "https://raw.github.com/notro/rpi-build/988e6741994b0124aad21f0740a63352124eaac2/patches/master/fbtft.patch;name=patch"

SRC_URI[fbtft.md5sum] = "28d315ff1f7fa2f35f286d7e60616fcf"                                     
SRC_URI[fbtft.sha256sum] = "fc23382c636278c81cff8f53ae9e0ede0cdbaa9f56bc589ad0734448f4e53a2b"
#SRC_URI[spi.md5sum] = "926d7c1a3eca590deedd26fda50e9110"                                        
#SRC_URI[spi.sha256sum] = "8022a2385fccef73bc7d11444f6acbd5dc9951e6103029848ca359532363128b"  
SRC_URI[patch.md5sum] = "bf17ba6e639698dc757ece6840a2176e"                                     
SRC_URI[patch.sha256sum] = "7a7dd4119571540052d5ec77ef21b069cf923a5fa94b9cb1a349085c1364a056"  

do_configure_prepend () {
	mv ${WORKDIR}/fbtft-238c3ad645a5a8214ec3190e621958d7d837ca21 ${S}/drivers/video/fbtft
#	mv ${WORKDIR}/spi-bcm2708.c ${S}/drivers/spi/
}

do_configure () {
	cat ${WORKDIR}/fbtft.cfg >> ${S}/.config
	yes '' | oe_runmake oldconfig
	kernel_do_configure
}

do_install_append () {
	echo "fbtft_device name=sainsmart18 verbose=0" > ${D}/etc/modules
}
