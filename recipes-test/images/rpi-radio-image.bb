# Base this image on core-image-minimal
include recipes-core/images/core-image-minimal.bb

# Include modules in rootfs
IMAGE_INSTALL += " \
	kernel-modules \
	qt4-embedded \
	qtserialport-e \
	wpa-supplicant \
	wireless-tools \
	"

IMAGE_FEATURES += "ssh-server-dropbear splash"
