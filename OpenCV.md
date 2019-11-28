```py
import cv2
# read image as np array
cv2.imread(path, cv2.CV_LOAD_IMAGE_GRAYSCALE) # read image as grayscale

# write np array as image
cv2.imwrite(path, image)

# display an image
cv2.imshow('image',image)
cv2.waitKey(0)
cv2.destroyAllWindows()
```
