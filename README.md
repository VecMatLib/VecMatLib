# VecMatLib

Hexagon VecMatLib provides simple structures for vectors and matrices and an implementation of all their basic operations.

## Design principles

- VecMatLab is lightweight, all operations use the fastest and most simple method.
- Vectors and matrices are immutable. All operations do not alter the object on which they are invoked, they return a new one instead.
- All operations implemented by vectors and matrices are intended to work similarly to java basic operators (examples below).

## How to use VecMatLib
Following is an overview of all the features that the project offers.

#### Vectors
Vectors are elements of a vector space which may be summed, subtracted or multiplied by a scalar.
VecMatLib offers structures for vectors of different sizes and types.

Vectors can either have a fixed size of 2, 3 or 4 dimensions or have a user-specified dimension.
VecMatLib supports float vectors and integer vectors.

Below is an example for the usage of a 3D float vector:
```
    // Two vectors containing three floats
    Float3 vector1 = new Float3(1.2f, 3.4f, 5.6f);
    Float3 vector2 = new Float3(1.0f, 2.0f, -1.5f);

    // sum = vector1 + vector2
    // result: (2.2f, 5.4f, 4.1f)
    Float3 sum = vector1.plus(vector2);
```

Vector objects are immutable.
This means `sum = vector1.plus(vector2)` does not affect `vector1` and `vector2`.

To increment a vector: `vector = vector.plus(x, y, z)`

Performing certain operations between two vectors of a different data type will convert the type of the vector accordingly.
For example, adding together a float vector and an integer vector will give a float vector as a result:
```
    Float2 vector1 = new Float2(1.2f, 3.4f);
    Int2 vector2 = new Int2(3, 2);
    // The result of the sum is a Float2 (4.2f, 5.4f)
    Float2 sum = vector1.plus(vector2);
```

Vectors of user-specified size can have any possible size and offer the same operations:
```
    IntN vec1 = new Int(0, 1, 2, 3, 4, 5, 6, 7, 8, 9); // A 10-dimensional int vector
    FloatN vec2 = vec1.times(1.5f);
```

#### Matrices
A Matrix is a table of numbers arranged in rows and columns.
They follow the same principles as vectors.
They can have a size of 3x3, 4x4 or a user-specified size.

The example below shows the creation of a 3x3 matrix:
```
    Matrix3 mat = Matrix3.fromRows(
        new Float3(1.0f, 0.0f, 0.0f),
        new Float3(0.0f, 1.0f, 0.0f),
        new Float3(0.0f, 0.0f, 1.0f)
    );
```

The example below shows the creation of a 4x5 matrix:
```
    Matrix mat = Matrix.fromRows(
        new FloatN(1.0f, 2.0f, 4.0f, 3.0f, 5.0f),
        new FloatN(2.0f, 1.0f, 3.0f, 5.0f, 4.0f),
        new FloatN(4.0f, 3.0f, 5.0f, 1.0f, 2.0f),
        new FloatN(3.0f, 5.0f, 1.0f, 4.0f, 3.0f)
    );
```

Two matrices can be summed and subtracted.
```
    matrix = mat1.plus(mat2);
    matrix = mat1.minus(mat2);
```

Matrices can be multiplied by a scalar, by a vector or by another matrix
```
    Matrix m = matrix.multiply(2.5f);
    Vector v = matrix.multiply(vector);
    Matrix m = matrix1.multiply(matrix2);
```

#### Transformation
4x4 matrices can be used to apply translations, rotations and scaling.
```
    Matrix4 matrix = Transformation.translation(new Float3(tx, ty, tz));
```
Multiplying a vector in the form `Float4(x, y, z, 1.0f)` by the matrix above
will apply the translation of vector `(tx, ty, tz)` to the point `(x, y, z)`.

The same applies for rotations on x, y or z axis and for scaling.